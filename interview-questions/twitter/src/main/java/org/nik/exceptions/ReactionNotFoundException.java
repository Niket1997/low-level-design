package org.nik.exceptions;

public class ReactionNotFoundException extends RuntimeException {
    public ReactionNotFoundException(String message) {
        super(message);
    }
}
