package kusitms.server.domain.tumbler.current.repository;

import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.tumbler.current.entity.TumblerCurrent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TumblerCurrentRepository extends JpaRepository<TumblerCurrent, Long> {

    TumblerCurrent findByDepartment(Department department);

}
