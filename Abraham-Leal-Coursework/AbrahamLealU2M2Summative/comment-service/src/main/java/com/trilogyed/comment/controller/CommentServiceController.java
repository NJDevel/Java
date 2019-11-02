package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class CommentServiceController {

    @Autowired
    private CommentDao commentDao;

    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return commentDao.addComment(comment);
    }

    @GetMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Comment findComment(@PathVariable int id) {
        return commentDao.getComment(id);
    }

    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Comment> findAllComments() {
        return  commentDao.getAllComments();
    }

    @PutMapping(value = "/comments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateComment(@RequestBody Comment comment) {
        commentDao.updateComment(comment);
        return  "Comment: " + comment.getCommentId() + " has been updated.";
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteComment(@PathVariable int id) {
        commentDao.deleteComment(id);
        return "The comment: " + id + " has been deleted.";
    }

    @GetMapping(value = "/commentsByPost/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Comment> findCommentsByPost(@PathVariable int id) {
        return commentDao.getAllCommentsForPost(id);
    }
}
