package ru.omsu.imit.facade;

/**
 * class for exceptions caused on token generation stage
 */
public class TokenGenerateException extends Exception {

    /**
     * TokenGenerateException constructor with one parameter.
     *
     * @param message error message
     */
    public TokenGenerateException(final String message) {
        super(message);
    }

    /**
     * TokenGenerateException constructor with two parameters.
     *
     * @param message error message
     * @param cause   exception that was a cause. Necessary to keep stacktrace
     */
    public TokenGenerateException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
