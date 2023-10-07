package kusitms.server.domain.sample.repository;


import kusitms.server.domain.sample.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
    Boolean existsByText(String text);
}
