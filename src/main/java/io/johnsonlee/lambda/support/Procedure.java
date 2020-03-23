package io.johnsonlee.lambda.support;

/**
 * Represents a code block which has result
 *
 * @param <R> The type of result
 * @param <E> The type of exception
 * @author johnsonlee
 * @see Block
 */
public interface Procedure<R, E extends Throwable> {

    R invoke() throws E;

}
