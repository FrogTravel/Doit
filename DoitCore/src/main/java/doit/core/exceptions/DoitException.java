package doit.core.exceptions;

/**
 * Created by Almaz on 16.08.2015.
 */
public class DoitException extends Exception {
    public DoitException(String message) {
        super(message);
    }

    public DoitException(String message, Throwable cause) {
        super(message, cause);
    }
}
