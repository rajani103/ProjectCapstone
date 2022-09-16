package com.stackroute.exception;

public class InterviewerDoesNotHaveSlotBoookedException extends Throwable {
    private String message;

    public InterviewerDoesNotHaveSlotBoookedException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InterviewrDoesNotHaveSLotBoookedException{" +
                "message='" + message + '\'' +
                '}';
    }
}
