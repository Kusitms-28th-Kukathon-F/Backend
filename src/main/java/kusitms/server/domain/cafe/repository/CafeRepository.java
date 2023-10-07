package kusitms.server.domain.cafe.repository;


import kusitms.server.domain.cafe.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
