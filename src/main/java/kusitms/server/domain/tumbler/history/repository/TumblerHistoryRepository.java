package kusitms.server.domain.tumbler.history.repository;

import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TumblerHistoryRepository extends JpaRepository<TumblerHistory, Long> {

    TumblerHistory findByCreatedAtBetweenAndDepartment(LocalDateTime searchStartDate, LocalDateTime searchEndDate, Department department);

    List<TumblerHistory> findAllByCreatedAtBetweenAndDepartment(LocalDateTime searchStartDate, LocalDateTime searchEndDate, Department department);
    List<TumblerHistory> findAllByCreatedAtBetweenOrderByTumblerCountDesc(LocalDateTime searchStartDate, LocalDateTime searchEndDate);

    List<TumblerHistory> findAllByCreatedAtBetween(LocalDateTime searchStartDate, LocalDateTime searchEndDate);
    List<TumblerHistory> findAllByDepartmentOrderByCreatedAtDesc(Department departcafement);
}
