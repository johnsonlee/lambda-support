package io.johnsonlee.lambda.support;

/**
 * Represents a code block with exception throwing
 *
 * @param <E> The type of exception
 * @author johnsonlee
 * @see Procedure
 */
@FunctionalInterface
public interface Block<E extends Throwable> {

    void invoke() throws E;

}
