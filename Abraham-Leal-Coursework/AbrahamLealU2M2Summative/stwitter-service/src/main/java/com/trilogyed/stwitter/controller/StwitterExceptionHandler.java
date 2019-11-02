package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.CommentDoesNotExist;
import com.trilogyed.stwitter.exception.PostDoesNotExist;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class StwitterExceptionHandler {

    @ExceptionHandler(value = {PostDoesNotExist.class})
        @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
        public ResponseEntity<VndErrors> postNotFoundError(PostDoesNotExist e, WebRequest request) {
            VndErrors error = new VndErrors(request.toString(), e.getMessage());
            ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
            return responseEntity;
        }

    @ExceptionHandler(value = {CommentDoesNotExist.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> commentNotFoundError(CommentDoesNotExist e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}