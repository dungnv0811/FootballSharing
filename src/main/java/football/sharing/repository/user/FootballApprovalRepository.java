package football.sharing.repository.user;

import football.sharing.domain.FootballApproval;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FootballApprovalRepository extends MongoRepository<FootballApproval, String> {
    boolean deleteByUserIdAndClientIdAndScope(FootballApproval footballApproval);

    List<FootballApproval> findByUserIdAndClientId(String userId, String clientId);
}
