package io.johnsonlee.lambda.support;

/**
 * @author johnsonlee
 */
public class UncheckedException extends RuntimeException {

    public UncheckedException() {
    }

    public UncheckedException(final String message) {
        super(message);
    }

    public UncheckedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UncheckedException(final Throwable cause) {
        super(cause);
    }
}
