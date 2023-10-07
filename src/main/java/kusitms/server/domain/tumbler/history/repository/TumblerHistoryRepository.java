package kusitms.server.domain.tumbler.history.repository;

import kusitms.server.domain.tumbler.history.entity.TumblerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TumblerHistoryRepository extends JpaRepository<TumblerHistory, Long> {

}
