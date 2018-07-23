package football.sharing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:messages.properties"})
public class FootballConfiguration {
}
