package com.stackroute.exception;

public class TagTeamDoesNotHaveSlotBoookedException extends Throwable {
    private String message;

    public TagTeamDoesNotHaveSlotBoookedException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String toString() {
        return "TagTeamDoesNotHaveSlotBoookedException{" +
                "message='" + message + '\'' +
                '}';
    }
}
