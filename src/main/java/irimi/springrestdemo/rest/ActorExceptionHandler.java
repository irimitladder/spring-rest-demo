package irimi.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActorExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ActorErrorData> handleException(ActorNotFoundException exception) {
        ResponseEntity<ActorErrorData> response = createExceptionResponse(exception, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity<ActorErrorData> handleException(Exception exception) {
        ResponseEntity<ActorErrorData> response = createExceptionResponse(exception, HttpStatus.BAD_REQUEST);
        return response;
    }

    private ResponseEntity<ActorErrorData> createExceptionResponse(Exception exception, HttpStatus httpStatus) {
        int statusCode = httpStatus.value();
        String message = exception.getMessage();
        long timeStamp = System.currentTimeMillis();
        ActorErrorData data = new ActorErrorData(statusCode, message, timeStamp);
        ResponseEntity<ActorErrorData> response = new ResponseEntity<>(data, httpStatus);
        return response;
    }
}
