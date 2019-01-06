package football.sharing.service.implementation;

import football.sharing.service.api.DateService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
final class JodaDateService implements DateService {

    private final DateTimeZone dateTimeZone;

    /**
     * Force system-wide timezone to ensure consistent
     * dates over all servers, independently from the region
     * the server is running.
     */
    JodaDateService(final DateTimeZone dateTimeZone) {
        super();
        this.dateTimeZone = checkNotNull(dateTimeZone);

        System.setProperty("user.timezone", dateTimeZone.getID());
        TimeZone.setDefault(dateTimeZone.toTimeZone());
        DateTimeZone.setDefault(dateTimeZone);
    }

    @Override
    public DateTime now() {
        return DateTime.now(dateTimeZone);
    }
}
