package doit.core.exceptions;

/**
 * Created by Almaz on 23.08.2015.
 */
public class DoitDatabaseException extends DoitException {
    public DoitDatabaseException(String message) {
        super(message);
    }

    public DoitDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
