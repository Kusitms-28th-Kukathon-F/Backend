package kusitms.server.domain.cafe.service;

import kusitms.server.domain.cafe.dto.request.UpdateTeamTumblerRequestDto;
import kusitms.server.domain.cafe.dto.response.UpdateTeamTumblerResponseDto;
import kusitms.server.domain.cafe.repository.CafeRepository;
import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.department.repository.DepartmentRepository;
import kusitms.server.domain.tumbler.current.entity.TumblerCurrent;
import kusitms.server.domain.tumbler.current.repository.TumblerCurrentRepository;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import kusitms.server.domain.tumbler.history.repository.TumblerHistoryRepository;
import kusitms.server.domain.tumbler.history.service.TumblerHistoryService;
import kusitms.server.domain.user.entity.User;
import kusitms.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class CafeService {

    private final CafeRepository cafeRepository;

    private final TumblerHistoryRepository tumblerHistoryRepository;
    private final TumblerHistoryService tumblerHistoryService;
    private final TumblerCurrentRepository tumblerCurrentRepository;


    public UpdateTeamTumblerResponseDto addTumblerCurrent(Long userId) {

        User finduser = tumblerHistoryService.getUserById(userId);
        Department department = tumblerHistoryService.getDepartmentByUser(finduser);
        Long deptId = department.getId(); // 부서 id

        TumblerCurrent tumblerCurrent = tumblerCurrentRepository.findByDepartment(department);
        tumblerCurrent.updateTumblerCount();

        LocalDateTime now = LocalDateTime.now();
        TumblerHistory tumblerHistory = tumblerHistoryRepository.findByCreatedAtBetweenAndDepartment
                (tumblerHistoryService.createStartMonthDate("202310"),
                        tumblerHistoryService.createEndMonthDate("202310"),
                        department);
        tumblerHistory.updateTumblerCount();

        UpdateTeamTumblerResponseDto res = UpdateTeamTumblerResponseDto.builder()
                .deptName(department.getDeptName())
                .build();

        return res;

    }
}
