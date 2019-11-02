package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.domain.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @PostMapping(value = "/posts")
    Post createPost(@RequestBody Post post);

    @GetMapping(value = "/posts/{id}")
    Post getPost(@PathVariable int id);

    @GetMapping(value = "/posts")
    List<Post> getAllPosts();

    @GetMapping(value = "/posts/user/{poster_name}")
    List<Post> getPostsByPoster(@PathVariable String poster_name);

    @PutMapping(value = "/posts")
    void updatePost(@RequestBody Post post);

    @DeleteMapping(value = "/posts/{id}")
     void deletePost(@PathVariable int id);
}
