package com.plomber.user.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException() {
        super("Email exists");
    }

}
