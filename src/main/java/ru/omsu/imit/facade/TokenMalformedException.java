package ru.omsu.imit.facade;

/**
 * An exception class for exceptions caused by malformed token
 */
public class TokenMalformedException extends Exception {

    /**
     * The constructor.
     *
     * @param message exception message
     */
    public TokenMalformedException(final String message) {
        super(message);
    }

    /**
     * The constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public TokenMalformedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
