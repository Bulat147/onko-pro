package ru.onko.exceptions;

public class AccessHashExpiresException extends RuntimeException {
    public AccessHashExpiresException(String message) {
        super(message);
    }
}
