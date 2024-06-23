package org.nik.exceptions;

public class ReactionCountNotFoundException extends RuntimeException {
    public ReactionCountNotFoundException(String message) {
        super(message);
    }
}
