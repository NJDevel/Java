package com.trilogyed.glossaryservice.exception;

public class NaughtyWordException extends IllegalArgumentException {
    public NaughtyWordException(String errorMessage) {
        super(errorMessage);
    }
}
