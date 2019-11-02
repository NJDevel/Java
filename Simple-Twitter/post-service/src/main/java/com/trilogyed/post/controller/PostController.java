package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    private PostDao postDao;

    @PostMapping(value = "/posts")
    public Post createPost(@RequestBody Post post) { return postDao.addPost(post); }

    @GetMapping(value = "/posts/{id}")
    public Post getPost(@PathVariable int id) {
        return postDao.getPost(id);
    }

    @GetMapping(value = "/posts/user/{poster_name}")
    public List<Post> getPostbyPoster(@PathVariable String poster_name) {return postDao.getPostsForPoster(poster_name);}

    @GetMapping(value = "/posts")
    public List<Post> getAllPosts() {return postDao.getAllPosts();}

    @PutMapping(value = "/posts")
    public void updatePost(@RequestBody Post post) {

        postDao.updatePost(post);
    }
    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable int id) { postDao.deletePost(id); }

}
