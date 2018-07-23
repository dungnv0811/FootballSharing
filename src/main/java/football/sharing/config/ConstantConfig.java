package football.sharing.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ConstantConfig {
    @Value("${app.authorization.client.id}")
    private String clientId;
    @Value("${app.authorization.client.secret}")
    private String clientSecret;
    @Value("${app.authorization.grant.type.password}")
    private String grantTypePassword;
    @Value("${app.authorization.grant.type.authorization-code}")
    private String grantTypeAuthorizationCode;
    @Value("${app.authorization.grant.type.refresh-token}")
    private String grantTypeRefreshToken;
    @Value("${app.authorization.grant.type.implicit}")
    private String grantTypeImplicit;
    @Value("${app.authorization.scope.read}")
    private String scopeRead;
    @Value("${app.authorization.scope.write}")
    private String scopeWrite;
    @Value("${app.authorization.scope.trust}")
    private String scopeTrust;
    @Value("${app.authorization.validity.second.access-token}")
    private int validityAccessToken;
    @Value("${app.authorization.validity.second.refresh-token}")
    private int validityRefreshToken;
    @Value("${app.authorization.time-out}")
    private int timeOut;
}
