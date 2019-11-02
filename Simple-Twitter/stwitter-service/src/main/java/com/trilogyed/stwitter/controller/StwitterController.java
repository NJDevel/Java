package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class StwitterController {

    @Autowired
    ServiceLayer service;

    /**************************************************************
     Post API
     **************************************************************/

    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel addPost(@RequestBody PostViewModel postViewModel) {
        return service.addPost(postViewModel);
    }

    @PutMapping(value = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public String updatePost(@RequestBody PostViewModel pvm) {
        //Update post in service layer
        service.updatePost(pvm);
        return "The Post with ID: " + pvm.getPostId() + " has been updated: \n" + pvm.toString();
    }
    @GetMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return service.getPost(id);
    }

    @DeleteMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePost(@PathVariable int id) {
        //Delete in service layer
        service.deletePost(id);
        return "The Post with ID: " + id + " has been deleted.";
    }

    @GetMapping(value = "/posts/user/{poster_name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostsbyPoster(@PathVariable String poster_name) {
        return service.getPostsbyPoster(poster_name);
    }


    /**************************************************************
     Comment API
     **************************************************************/
    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public String addComment(@RequestBody Comment comment) {
        //servicelayer create comment
        service.addComment(comment);
        return "Comment has been posted!";
    }

    @PutMapping(value = "/comments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateComment(Comment comment) {
        //service layer update comment
        service.updateComment(comment);
        return "Comment has been updated.";
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteComment(@PathVariable int id) {
        //servicelayer delete comment
        return "Comment has been deleted.";
    }
}
