package com.stackroute.exception;

public class BookedSlotIDNotFoundForTechTrackException extends Throwable {
    private String message;

    public BookedSlotIDNotFoundForTechTrackException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SlotIDNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}
