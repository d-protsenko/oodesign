package ru.omsu.imit.facade;

/**
 * An exception class for exceptions caused on token parsing stage
 */
public class TokenParseException extends Exception {

    /**
     * The constructor.
     *
     * @param message exception message
     */
    public TokenParseException(final String message) {
        super(message);
    }

    /**
     * The constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public TokenParseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
