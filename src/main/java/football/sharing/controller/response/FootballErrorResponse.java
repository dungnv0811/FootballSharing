package football.sharing.controller.response;

public class FootballErrorResponse extends FootballResponse {

    private String error;

    public FootballErrorResponse(String message) {
        super(false);
        this.error = message;
    }

    public String getError() {
        return error;
    }
}
