package football.sharing.controller;

import football.sharing.config.MessageConfiguration;
import football.sharing.controller.response.FootballErrorResponse;
import football.sharing.exception.FootballBadRequestException;
import football.sharing.exception.FootballNotFoundException;
import football.sharing.exception.FootballServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class FootballResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageConfiguration messageConfiguration;

    public FootballResponseExceptionHandler(MessageConfiguration messageConfiguration) {
        this.messageConfiguration = messageConfiguration;
    }

    // return 500 INTERNAL_SERVER_ERROR
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest webRequest) {
        log.error("Exception occurred when processing request", exception);
        return new ResponseEntity<>("Resource Not Found", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return 400 BAD_REQUEST
    @ExceptionHandler(FootballBadRequestException.class)
    protected ResponseEntity<Object> handleException(FootballBadRequestException exception, WebRequest webRequest) {
        log.error("Exception processing request", exception);
        return new ResponseEntity<>(new FootballErrorResponse(exception.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    // return 500 INTERNAL_SERVER_ERROR
    @ExceptionHandler(FootballServiceException.class)
    protected ResponseEntity<Object> handleException(FootballServiceException exception, WebRequest webRequest) {
        log.error("Exception processing request", exception);

        String message;

        if (StringUtils.isEmpty(exception.getMessage())) {
            message = "Football service encountered an unexpected error";
        } else {
            message = exception.getMessage();
        }

        return new ResponseEntity<>(new FootballErrorResponse(message), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return 404 NOT_FOUND
    @ExceptionHandler(FootballNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(FootballNotFoundException exception, WebRequest webRequest) {
        log.error("Exception processing request", exception);

        String message;

        if (StringUtils.isEmpty(exception.getMessage())) {
            message = messageConfiguration.getExceptionNotFound();
        } else {
            message = exception.getMessage();
        }
        return new ResponseEntity<>(new FootballErrorResponse(message), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
