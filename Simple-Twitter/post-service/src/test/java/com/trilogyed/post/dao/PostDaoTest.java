package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostDaoTest {

    @Autowired
    private PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> posts = postDao.getAllPosts();

        posts.stream()
                .forEach(post -> postDao.deletePost(post.getPostId()));
    }

    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPost("This is my first post!");
        post.setPostDate(LocalDate.of(2019, 9, 25));
        post.setPosterName("George Washington");
        post = postDao.addPost(post);

        Post post1 = new Post();
        post1 = postDao.getPost(post.getPostId());

        //Tests the add and get functions
        assertEquals(post, post1);

        post1.setPost("This is my Halloween post!");
        post1.setPostDate(LocalDate.of(2019, 10, 31));
        post1.setPosterName("John Adams");
        //Adds a second post to database
        post1 = postDao.addPost(post1);

        //Asserts two posts currently in database
        assertEquals(2, postDao.getAllPosts().size());

        //Deletes one post and asserts new size of post database
        postDao.deletePost(post.getPostId());
        assertEquals(1, postDao.getAllPosts().size());

    }

    @Test
    public void getAllPosts() {
        //Loads three posts to the database
        helperPostDataLoad();
        assertEquals(3, postDao.getAllPosts().size());
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPost("This is my first post!");
        post.setPostDate(LocalDate.of(2019, 9, 25));
        post.setPosterName("George Washington");
        post = postDao.addPost(post);


        post.setPost("This is my Halloween post!");
        post.setPostDate(LocalDate.of(2019, 10, 31));
        post.setPosterName("John Adams");

        //Update original post
        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostId());
        //Assert post has been updated
        assertEquals(post, post1);
        assertEquals("John Adams", post1.getPosterName());

    }

    @Test
    public void getPostsForPoster() {
        //Loads three posts to database, including two by George Washington
        helperPostDataLoad();

        assertEquals(2,postDao.getPostsForPoster("George Washington").size());
    }

    private void helperPostDataLoad() {
        Post post = new Post();
        post.setPost("This is my first post!");
        post.setPostDate(LocalDate.of(2019, 9, 25));
        post.setPosterName("George Washington");
        post = postDao.addPost(post);

        Post post1 = new Post();
        post1.setPost("This is my Halloween post!");
        post1.setPostDate(LocalDate.of(2019, 10, 31));
        post1.setPosterName("John Adams");
        post1 = postDao.addPost(post1);

        Post post2 = new Post();
        post2.setPost("This is my second post!");
        post2.setPostDate(LocalDate.of(2019, 10, 18));
        post2.setPosterName("George Washington");
        post2 = postDao.addPost(post);
    }
}