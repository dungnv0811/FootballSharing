package football.sharing.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MessageConfiguration {
    @Value("${exception.not_found}")
    private String exceptionNotFound;
}
