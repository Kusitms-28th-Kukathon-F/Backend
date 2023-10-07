package kusitms.server.domain.company.repository;


import kusitms.server.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
