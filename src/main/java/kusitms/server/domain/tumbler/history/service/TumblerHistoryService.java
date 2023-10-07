package kusitms.server.domain.tumbler.history.service;

import kusitms.server.domain.common.error.ApplicationError;
import kusitms.server.domain.common.error.NotFoundException;
import kusitms.server.domain.company.entity.Company;
import kusitms.server.domain.company.repository.CompanyRepository;
import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.department.repository.DepartmentRepository;
import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import kusitms.server.domain.tumbler.history.repository.TumblerHistoryRepository;
import kusitms.server.domain.tumbler.history.util.ListComparator;
import kusitms.server.domain.user.entity.User;
import kusitms.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static kusitms.server.domain.common.error.ApplicationError.DEPARTMENT_NOT_FOUND;
import static kusitms.server.domain.common.error.ApplicationError.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
@Transactional
public class TumblerHistoryService {

    private final TumblerHistoryRepository tumblerHistoryRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;


    public List<HistoryMonthDetailResponseDto> findDetailByMonth(String period, Long userId) {
        User finduser = getUserById(userId);
        Department userDepartment = getDepartmentByUser(finduser);
        Company company = userDepartment.getCompany();
        List<Department> departments = company.getDepartments();
        List<HistoryMonthDetailResponseDto> response = new ArrayList<>();
        LocalDateTime startMonthDate = createStartMonthDate(period);
        LocalDateTime endMonthDate = createEndMonthDate(period);
        departments.forEach(department ->
                response.add(
                        HistoryMonthDetailResponseDto.of(findHistoryInPeriod(startMonthDate, endMonthDate, department))
                )
        );
        response.sort(new ListComparator());

        return response;
    }


    // 월별 검색을 할때 1일 0시0분0초 값을 추가 해줘서 범위의 처음 값을 만듭니다.
    private LocalDateTime createStartMonthDate(String period) {
        period += "01";
        LocalDateTime startDateTime = LocalDate.parse(period, DateTimeFormatter.ofPattern("yyyyMMdd")).atTime(0,0,0);
        return startDateTime;
    }

    // 월별 검색을 할때 31일 23시59분59초 값을 추가 해줘서 범위의 마지막 값을 만듭니다.
    private LocalDateTime createEndMonthDate(String period) {
        period += "31";
        LocalDateTime endDateTime = LocalDate.parse(period, DateTimeFormatter.ofPattern("yyyyMMdd")).atTime(23,59,59);
        return endDateTime;
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
    }

    private Department getDepartmentByUser(User user) {
        return departmentRepository.findByUser(user)
                .orElseThrow(() -> new NotFoundException(DEPARTMENT_NOT_FOUND));
    }

    private TumblerHistory findHistoryInPeriod(LocalDateTime searchStartDate, LocalDateTime searchEndDate, Department department) {
        TumblerHistory tumblerHistory = tumblerHistoryRepository.findByCreatedAtBetweenAndDepartment(searchStartDate, searchEndDate, department);
        return tumblerHistory;
    }

}
