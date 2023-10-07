package kusitms.server.domain.department.repository;

import kusitms.server.domain.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
