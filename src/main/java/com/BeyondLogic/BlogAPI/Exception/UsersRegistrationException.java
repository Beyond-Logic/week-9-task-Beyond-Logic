package com.BeyondLogic.BlogAPI.Exception;

public class UsersRegistrationException extends RuntimeException {
    public UsersRegistrationException(String message) {
        super(message);
    }

    public UsersRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}