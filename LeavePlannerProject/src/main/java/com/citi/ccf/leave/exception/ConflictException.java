package com.citi.ccf.leave.exception;


public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String resourceName, String conflictDetail) {
        super(String.format("%s conflict: %s", resourceName, conflictDetail));
    }
}