package kusitms.server.domain.tumbler.current.service;

import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.department.repository.DepartmentRepository;
import kusitms.server.domain.tumbler.current.dto.request.MainRequestDto;
import kusitms.server.domain.tumbler.current.dto.response.MainResponseDto;
import kusitms.server.domain.tumbler.current.entity.TumblerCurrent;
import kusitms.server.domain.tumbler.current.repository.TumblerCurrentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TumblerCurrentService {

    private final DepartmentRepository departmentRepository;
    private final TumblerCurrentRepository tumblerCurrentRepository;

    public MainResponseDto getTumblerCurrent(Long userId) {

//        Long userId = mainRequestDto.getUserId();

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

        MainResponseDto res = MainResponseDto.builder()
                .tumblerGrade(tumblerGrade)
                .tumblerName(tumblerName)
                .deptName(deptName)
                .tumblerPercent(tumblerPercent)
                .toGoalCount(tumblerGoal - tumblerCount)
                .build();

        return res;

    }


}
