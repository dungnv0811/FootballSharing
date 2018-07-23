package football.sharing.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "football_oauth2_refresh_token")
@Data
public class FootballOAuth2RefreshToken {

    @Id
    private String tokenId;
    private byte[] token;
    private byte[] authentication;

    @PersistenceConstructor
    public FootballOAuth2RefreshToken(final String tokenId,
                                   final byte[] token,
                                   final byte[] authentication) {
        this.tokenId = tokenId;
        this.token = token;
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FootballOAuth2RefreshToken)) return false;

        FootballOAuth2RefreshToken that = (FootballOAuth2RefreshToken) o;

        return new EqualsBuilder()
            .append(tokenId, that.tokenId)
            .append(token, that.token)
            .append(authentication, that.authentication)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(tokenId)
            .append(token)
            .append(authentication)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("tokenId", tokenId)
            .append("token", token)
            .append("authentication", authentication)
            .toString();
    }
}
