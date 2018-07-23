package football.sharing.exception;

public class FootballServiceException extends FootballException {

    public FootballServiceException(String message) {
        super(message);
    }

    public FootballServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
