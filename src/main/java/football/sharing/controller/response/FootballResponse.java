package football.sharing.controller.response;

public class FootballResponse {

    private boolean success;

    public FootballResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
