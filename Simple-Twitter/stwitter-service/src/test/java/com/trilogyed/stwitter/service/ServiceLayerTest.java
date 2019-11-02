package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.Post;
import com.trilogyed.stwitter.domain.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    PostServiceClient postServiceClient;
    CommentServiceClient commentServiceClient;
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
        //Mocks
        setUpPostClientMock();
        setUpCommentClientMock();
        setUpRabbitMock();
        serviceLayer = new ServiceLayer(postServiceClient, commentServiceClient, rabbitTemplate);
    }

    private void setUpPostClientMock() {
        postServiceClient = mock(PostServiceClient.class);

        Post post = new Post();
        post.setPostId(1);
        post.setPost("This is my first post!");
        post.setPostDate(LocalDate.of(2019, 9, 25));
        post.setPosterName("George Washington");
        PostViewModel pvm = new PostViewModel(post);

        Post post0 = new Post();
        post0.setPost("This is my first post!");
        post0.setPostDate(LocalDate.of(2019, 9, 25));
        post0.setPosterName("George Washington");

        //Mocks adding a post
        doReturn(post).when(postServiceClient).createPost(post0);
        pvm.setPostId(post.getPostId());

        //Mocks returning a post
        doReturn(post).when(postServiceClient).getPost(1);

        Post post1 = new Post();
        post1.setPostId(2);
        post1.setPost("This is my Halloween post!");
        post1.setPostDate(LocalDate.of(2019, 10, 31));
        post1.setPosterName("John Adams");

        Post post2 = new Post();
        post2.setPostId(3);
        post2.setPost("This is my second post!");
        post2.setPostDate(LocalDate.of(2019, 10, 18));
        post2.setPosterName("George Washington");

        //Mock get all posts
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post1);
        posts.add(post2);
        doReturn(posts).when(postServiceClient).getAllPosts();

        PostViewModel pvm1 = new PostViewModel(post1);
        PostViewModel pvm2 = new PostViewModel(post2);

        //Mock Delete post
        doNothing().when(postServiceClient).deletePost(3);
        doReturn(null).when(postServiceClient).getPost(3);

        //Mock return of all posts by Poster George Washington
        List<Post> georgePosts = new ArrayList<>();
        georgePosts.add(post);
        georgePosts.add(post2);
        doReturn(georgePosts).when(postServiceClient).getPostsByPoster(post.getPosterName());

    }

    private void setUpCommentClientMock() {
        commentServiceClient = mock(CommentServiceClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");

        Comment comment0 = new Comment();
        comment0.setPostId(1);
        comment0.setCreateDate(LocalDate.now());
        comment0.setCommenterName("Thomas Jefferson");
        comment0.setComment("Nice post mate!");

        //Set up add comment mock? Rabbit?
        doReturn(comment).when(commentServiceClient).createComment(comment0);

        //Set up get comment mock
        doReturn(comment).when(commentServiceClient).findComment(1);


        Comment comment1 = new Comment();
        comment1.setCommentId(2);
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.now());
        comment1.setCommenterName("Ben Franklin");
        comment1.setComment("Wicked technology!");


        Comment comment2 = new Comment();
        comment2.setCommentId(3);
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("Thomas Jefferson");
        comment2.setComment("Even nicer post! Good job!");

        List<Comment> allComments = new ArrayList<>();
        allComments.add(comment);
        allComments.add(comment1);
        allComments.add(comment2);

        //Mocks return of all comments
        doReturn(allComments).when(commentServiceClient).findAllComments();

        //Mock return of all posts with post ID 1
        List<Comment> post1Comments = new ArrayList<>();
        post1Comments.add(comment);
        post1Comments.add(comment1);
        doReturn(post1Comments).when(commentServiceClient).findCommentsByPost(1);

        //Mock return of all posts with post ID 2
        List<Comment> post2Comments = new ArrayList<>();
        post2Comments.add(comment2);
        doReturn(post2Comments).when(commentServiceClient).findCommentsByPost(2);

    }

    private void setUpRabbitMock() {
        rabbitTemplate = mock(RabbitTemplate.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");

        Comment comment0 = new Comment();
        comment0.setPostId(1);
        comment0.setCreateDate(LocalDate.now());
        comment0.setCommenterName("Thomas Jefferson");
        comment0.setComment("Nice post mate!");

        //Set up add comment mock? Rabbit?
    }

    @Test
    public void addGetDeletePost() {

        Post post0 = new Post();
        post0.setPost("This is my first post!");
        post0.setPostDate(LocalDate.of(2019, 9, 25));
        post0.setPosterName("George Washington");

        PostViewModel pvm = new PostViewModel(post0);

        //Tests add posts through service layer
        pvm = serviceLayer.addPost(pvm);
        //Add comments to new post
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");

        Comment comment1 = new Comment();
        comment1.setCommentId(2);
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.now());
        comment1.setCommenterName("Ben Franklin");
        comment1.setComment("Wicked technology!");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        pvm.setComments(comments);

        //Tests getting a post through service layer
        PostViewModel pvm2 = serviceLayer.getPost(pvm.getPostId());

        //Asserts that save and get are working as expected
        assertEquals(pvm, pvm2);

        List<Post> posts = postServiceClient.getAllPosts();
        for(Post post : posts) {
            postServiceClient.createPost(post);
        }

        //Tests Delete
        serviceLayer.deletePost(posts.get(2).getPostId());
        assertNull(serviceLayer.getPost(posts.get(2).getPostId()).getPosterName());;

    }

    @Test
    public void updatePost() {


    }

    @Test
    public void getPostsbyPoster() {

        assertEquals(2, serviceLayer.getPostsbyPoster("George Washington").size());
    }

    @Test
    public void addComment() {
    }

    @Test
    public void updateComment() {
    }
}