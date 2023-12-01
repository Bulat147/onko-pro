package ru.onko.exceptions;

public class PermissionError extends RuntimeException {
    public PermissionError(String message) {
        super(message);
    }
}
