package ru.omsu.imit.facade;

/**
 * An exception class for exceptions caused by expired token
 */
public class TokenExpiredException extends Exception {

    /**
     * The constructor.
     *
     * @param message exception message
     */
    public TokenExpiredException(final String message) {
        super(message);
    }


    /**
     * The constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public TokenExpiredException(final String message, final Throwable cause) {
        super(message, cause);
    }
}