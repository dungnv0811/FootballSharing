package football.sharing.config;

import football.sharing.security.FootballTokenStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    private final FootballTokenStore footballTokenStore;
    private final AuthenticationManager authenticationManager;
    private final ConstantConfig constantConfig;

    public AuthorizationServerConfiguration(FootballTokenStore footballTokenStore, AuthenticationManager authenticationManager, ConstantConfig constantConfig) {
        this.footballTokenStore = footballTokenStore;
        this.authenticationManager = authenticationManager;
        this.constantConfig = constantConfig;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
            .inMemory()
            .withClient(constantConfig.getClientId())
            .secret(constantConfig.getClientSecret())
            .authorizedGrantTypes(constantConfig.getGrantTypePassword(), constantConfig.getGrantTypeAuthorizationCode(), constantConfig.getGrantTypeRefreshToken(), constantConfig.getGrantTypeImplicit())
            .scopes(constantConfig.getScopeRead(), constantConfig.getScopeWrite(), constantConfig.getScopeTrust())
            .accessTokenValiditySeconds(constantConfig.getValidityAccessToken()).
            refreshTokenValiditySeconds(constantConfig.getValidityRefreshToken());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(footballTokenStore)
            .authenticationManager(authenticationManager);
    }

    @Primary
    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setRefreshTokenValiditySeconds(constantConfig.getTimeOut());
        tokenServices.setTokenStore(footballTokenStore);
        return tokenServices;
    }
}