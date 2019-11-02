package com.trilogyed.stwitter.exception;

public class PostDoesNotExist extends IllegalArgumentException {
    public PostDoesNotExist(String errorMessage) {
        super(errorMessage);}
}
