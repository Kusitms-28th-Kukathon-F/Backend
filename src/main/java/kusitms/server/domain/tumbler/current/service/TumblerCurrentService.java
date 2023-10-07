package kusitms.server.domain.tumbler.current.service;

import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.department.repository.DepartmentRepository;
import kusitms.server.domain.tumbler.current.dto.response.MainResponseDto;
import kusitms.server.domain.tumbler.current.entity.TumblerCurrent;
import kusitms.server.domain.tumbler.current.repository.TumblerCurrentRepository;
import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import kusitms.server.domain.tumbler.history.repository.TumblerHistoryRepository;
import kusitms.server.domain.tumbler.history.service.TumblerHistoryService;
import kusitms.server.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class TumblerCurrentService {

    private final DepartmentRepository departmentRepository;
    private final TumblerCurrentRepository tumblerCurrentRepository;
    private final TumblerHistoryRepository tumblerHistoryRepository;
    private final TumblerHistoryService tumblerHistoryService;

    public MainResponseDto getTumblerCurrent(Long userId) {

        Department department = departmentRepository.findByUserId(userId);
        Long deptId = department.getId(); // 부서 id
        String deptName = department.getDeptName(); // 부서명
        Integer deptMemberCount = department.getMemberCount(); // 부서 사원 수

        TumblerCurrent tumblerCurrent = tumblerCurrentRepository.findByDepartment(department);
        String tumblerName = tumblerCurrent.getTumblerName(); // 텀블러 명
        Integer tumblerGoal = tumblerCurrent.getTumblerGoal(); // 이번달 부서별 텀블러 목표 수
        Integer tumblerCount = tumblerCurrent.getTumblerCount(); // 이번달 부서별 텀블러 적립 수
        Double tumblerPercent = tumblerCurrent.getTumblerPercent(); // 이번달 부서별 텀블러 퍼센트
        Integer tumblerGrade = tumblerCurrent.getTumblerGrade(); // 이번달 부서별 텀블러 등급

        List<HistoryMonthDetailResponseDto> rankList = tumblerHistoryService.findDetailByMonth("202310", userId);

        MainResponseDto res = MainResponseDto.builder()
                .tumblerGrade(tumblerGrade)
                .tumblerName(tumblerName)
                .deptName(deptName)
                .tumblerPercent(tumblerPercent)
                .toGoalCount(tumblerGoal - tumblerCount)
                .rankList(rankList)
                .build();

        return res;
    }

//    public void addTumblerCurrent(Long userId) {
//
//        User finduser = tumblerHistoryService.getUserById(userId);
//        Department department = tumblerHistoryService.getDepartmentByUser(finduser);
//        Long deptId = department.getId(); // 부서 id
//
//        TumblerCurrent tumblerCurrent = tumblerCurrentRepository.findByDepartment(department);
//        tumblerCurrent.updateTumblerCount();
//
//        LocalDateTime now = LocalDateTime.now();
//        TumblerHistory tumblerHistory = tumblerHistoryRepository.findByCreatedAtBetweenAndDepartment
//                (tumblerHistoryService.createStartMonthDate("202310"),
//                        tumblerHistoryService.createEndMonthDate("202310"),
//                        department);
//        tumblerHistory.updateTumblerCount();
//
//    }
}
