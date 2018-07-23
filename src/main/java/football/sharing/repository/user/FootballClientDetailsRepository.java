package football.sharing.repository.user;

import football.sharing.domain.FootballClientDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FootballClientDetailsRepository extends MongoRepository<FootballClientDetails, String> {
    boolean deleteByClientId(String clientId);

    FootballClientDetails findByClientId(String clientId);
}
