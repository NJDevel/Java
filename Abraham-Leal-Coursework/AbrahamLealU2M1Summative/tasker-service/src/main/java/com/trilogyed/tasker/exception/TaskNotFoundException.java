package com.trilogyed.tasker.exception;

public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

