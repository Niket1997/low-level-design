package org.nik.exceptions;

public class NewsfeedNotFoundException extends RuntimeException {
    public NewsfeedNotFoundException(String message) {
        super(message);
    }
}
