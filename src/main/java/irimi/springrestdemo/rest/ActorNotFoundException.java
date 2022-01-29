package irimi.springrestdemo.rest;

public class ActorNotFoundException
        extends RuntimeException {

    public ActorNotFoundException() {
    }

    public ActorNotFoundException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ActorNotFoundException(
            String message,
            Throwable cause) {
        super(message, cause);
    }

    public ActorNotFoundException(String message) {
        super(message);
    }

    public ActorNotFoundException(Throwable cause) {
        super(cause);
    }
}
