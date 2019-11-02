package com.trilogyed.stwitter.exception;

public class CommentDoesNotExist extends IllegalArgumentException {
    public CommentDoesNotExist(String errorMessage) {
        super(errorMessage);}
}
