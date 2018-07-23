package football.sharing.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FootballSuccessResponse<T> extends FootballResponse {
    private T data;

    public FootballSuccessResponse() {
        super(true);
    }

    public FootballSuccessResponse(T data) {
        super(true);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
