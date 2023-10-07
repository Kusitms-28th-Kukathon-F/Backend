package kusitms.server.domain.department.repository;

import kusitms.server.domain.company.entity.Company;
import kusitms.server.domain.department.entity.Department;
import kusitms.server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByUser(User user);

    List<Department> findAllByCompany(Company company);
}
