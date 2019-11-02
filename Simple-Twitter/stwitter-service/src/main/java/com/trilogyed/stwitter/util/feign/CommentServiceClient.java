package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    Comment createComment(@RequestBody Comment comment);

    @GetMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Comment findComment(@PathVariable int id);

    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Comment> findAllComments();

    @PutMapping(value = "/comments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String updateComment(@RequestBody Comment comment);

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String deleteComment(@PathVariable int id);

    @GetMapping(value = "/commentsByPost/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Comment> findCommentsByPost(@PathVariable int id);
}
