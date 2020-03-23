package io.johnsonlee.lambda.support;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Utilities for lambda expression
 *
 * @author johnsonlee
 */
public class LambdaSupport {

    /**
     * Wrap block as lambda expression without exception, for example:
     *
     * <pre>
     * stream.forEach(file -&gt; unchecked(() -&gt; {
     *     FileUtils.readAsString(file);
     * }));
     * </pre>
     *
     * @param block the consumer lambda to wrap
     * @param <E>   the type of exception
     */
    public static <E extends Throwable> void unchecked(final Block<? super E> block) {
        try {
            block.invoke();
        } catch (final Error | RuntimeException e) {
            throw e;
        } catch (final Throwable e) {
            throw new UncheckedException(e);
        }
    }

    /**
     * Wrap procedure as lambda expression without exception, for example:
     *
     * <pre>
     * stream.filter(file -&gt; unchecked(() -&gt; {
     *     return FileUtils.readAsString(file).endsWith(".class");
     * }));
     * </pre>
     *
     * @param procedure the function lambda to wrap
     * @param <R>       the type of result
     * @param <E>       the type of exception
     * @return the result
     */
    public static <R, E extends Throwable> R unchecked(final Procedure<R, E> procedure) {
        try {
            return procedure.invoke();
        } catch (final Error | RuntimeException e) {
            throw e;
        } catch (final Throwable e) {
            throw new UncheckedException(e);
        }
    }


    /**
     * Wrap consumer as lambda expression without exception
     *
     * @param object   the argument of consumer
     * @param consumer the consumer to be wrapped
     * @param <T>      The type of argument
     */
    public static <T> void with(final T object, final Consumer<? super T> consumer) {
        consumer.accept(object);
    }

    /**
     * Wrap function as lambda expression without exception
     *
     * @param object   the argument of function
     * @param function the function to be wrapped
     * @param <T>      The type of argument
     * @param <R>      The return type of function
     * @return The result of function
     */
    public static <T, R> R with(final T object, final Function<T, R> function) {
        return function.apply(object);
    }

    /**
     * Wrap bi-consumer as lambda expression without exception
     *
     * @param a        The first argument of bi-consumer
     * @param b        The second argument of bi-consumer
     * @param consumer The bi-consumer to be wrapped
     * @param <A>      The type of first argument
     * @param <B>      The type of second argument
     */
    public static <A, B> void with(final A a, final B b, final BiConsumer<A, B> consumer) {
        consumer.accept(a, b);
    }

    /**
     * Wrap bi-function as lambda expression without exception
     *
     * @param a        The first argument of bi-function
     * @param b        The second argument of bi-function
     * @param function The bi-function to be wrapped
     * @param <A>      The type of first argument
     * @param <B>      The type of second argument
     * @param <R>      The return type of bi-function
     * @return the result of bi-function
     */
    public static <A, B, R> R with(final A a, final B b, final BiFunction<A, B, R> function) {
        return function.apply(a, b);
    }

    private LambdaSupport() {
    }

}
