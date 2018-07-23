package football.sharing.repository.user;

import football.sharing.domain.FootballOAuth2RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FootballOAuth2RefreshTokenRepository extends MongoRepository<FootballOAuth2RefreshToken, String> {
    FootballOAuth2RefreshToken findByTokenId(String tokenId);

    void deleteByTokenId(String tokenId);
}
