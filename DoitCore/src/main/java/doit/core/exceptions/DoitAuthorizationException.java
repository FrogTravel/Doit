package doit.core.exceptions;

/**
 * Created by Almaz on 16.08.2015.
 */
public class DoitAuthorizationException extends DoitException{
    public DoitAuthorizationException(String message) {
        super(message);
    }

    public DoitAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
