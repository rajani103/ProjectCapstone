package com.stackroute.exception;

public class NoBookedSlotsExistsException extends Throwable {
    private String message;

    public NoBookedSlotsExistsException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoBookedSlotsExistsException{" +
                "message='" + message + '\'' +
                '}';
    }
}
