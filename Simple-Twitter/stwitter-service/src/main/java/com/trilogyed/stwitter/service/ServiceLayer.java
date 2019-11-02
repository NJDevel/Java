package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.Post;
import com.trilogyed.stwitter.domain.PostViewModel;
import com.trilogyed.stwitter.exception.CommentDoesNotExist;
import com.trilogyed.stwitter.exception.PostDoesNotExist;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.messages.CommentEntry;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    private PostServiceClient postServiceClient;
    @Autowired
    private CommentServiceClient commentServiceClient;

    private RabbitTemplate rabbitTemplate;
    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";

    @Autowired
    public ServiceLayer(PostServiceClient postServiceClient, CommentServiceClient commentServiceClient, RabbitTemplate rabbitTemplate) {
        this.postServiceClient = postServiceClient;
        this.commentServiceClient = commentServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    /**************************************************************
     Post API
     **************************************************************/
    @Transactional
    public PostViewModel addPost(PostViewModel pvm) {
        Post post = new Post(pvm);
        post = postServiceClient.createPost(post);
        PostViewModel returnPost = new PostViewModel(post);
        return returnPost;
    }

    public void updatePost(PostViewModel postViewModel) {
        Post post = new Post(postViewModel);
        post.setPostId(postViewModel.getPostId());
        List<Post> postIds = postServiceClient.getAllPosts();
        if(!postIds.contains(postViewModel.getPostId())){
            throw new PostDoesNotExist("The post ID: " + postViewModel.getPostId() + " does not exist. Please " +
                    "enter a comment for a valid post." );
        }
        postServiceClient.updatePost(post);
    }

    public PostViewModel getPost(@PathVariable int id) {

        Post post = postServiceClient.getPost(id);

        List<Post> postIds = postServiceClient.getAllPosts();
        if(!postIds.contains(id)){
            throw new PostDoesNotExist("The post ID: " + id + " does not exist. Please " +
                    "enter search for a valid post." );
        }
        PostViewModel pvm = new PostViewModel();
        return pvm;
    }

    public void deletePost(int id) {
        if(postServiceClient.getPost(id).equals(null)){
            throw new PostDoesNotExist("The post ID: " + id + " does not exist. Please " +
                    "enter the ID for a valid post." );
        }
        postServiceClient.deletePost(id);
    }

    public List<PostViewModel> getPostsbyPoster(@PathVariable String poster_name) {
        List<Post> posts = postServiceClient.getPostsByPoster(poster_name);

        //Add PostViewModels to list
        PostViewModel pvm = new PostViewModel();
        List<PostViewModel> returnPosts = new ArrayList<>();
        for(Post post : posts) {
            returnPosts.add(viewModelBuilder(post));
        }
        return returnPosts;
    }

    private PostViewModel viewModelBuilder(Post post) {
        PostViewModel pvm = new PostViewModel(post);
        List<Post> postIds = postServiceClient.getAllPosts();
        if(!postIds.contains(post.getPostId())){
            throw new PostDoesNotExist("The post ID: " + post.getPostId() + " does not exist. Please " +
                    "enter an ID for a valid post." );
        }
        pvm.setComments(commentServiceClient.findCommentsByPost(pvm.getPostId()));
        return pvm;
    }

    /**************************************************************
     Comment API
     **************************************************************/

    @Transactional
    public void addComment(Comment comment) {
        //Perhaps return void for msg sent
        PostViewModel pvm = new PostViewModel();

        List<Post> postIds = postServiceClient.getAllPosts();
        if(!postIds.contains(comment.getPostId())){
            throw new PostDoesNotExist("The post ID: " + comment.getPostId() + " does not exist. Please " +
                    "enter a comment for a valid post." );
        }

        //Comment Client service - Message Queue
        CommentEntry msg = new CommentEntry(comment);
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        System.out.println("Message Sent");

    }

    public PostViewModel updateComment(Comment comment) {
        List<Comment> commentIds = commentServiceClient.findAllComments();
        if(!commentIds.contains(comment.getCommentId())) {
            throw new CommentDoesNotExist("The comment ID: " + comment.getCommentId() + " does not exist. Please " +
                    "enter an ID for a valid comment.");
        }
        commentServiceClient.updateComment(comment);
        PostViewModel pvm = new PostViewModel();
        //Build PVM with updated comment
        return pvm;
    }

    public void deleteComment(int id) {
        List<Comment> commentIds = commentServiceClient.findAllComments();
        if(!commentIds.contains(id)) {
            throw new CommentDoesNotExist("The comment ID: " + id + " does not exist. Please " +
                    "enter an ID for a valid comment.");
        }
        commentServiceClient.deleteComment(id);
    }
}