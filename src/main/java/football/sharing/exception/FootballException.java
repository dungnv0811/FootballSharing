package football.sharing.exception;

public class FootballException extends RuntimeException {
    public FootballException() {

    }

    public FootballException(String message) {
        super(message);
    }

    public FootballException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
