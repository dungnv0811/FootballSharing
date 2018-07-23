package football.sharing.exception;

public class FootballBadRequestException extends FootballException {

    public FootballBadRequestException(String message) {
        super(message);
    }

    public FootballBadRequestException(final String message, final Throwable cause)
    {
        super(message, cause);
    }
}
