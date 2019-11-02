package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Before
    public void setUp() throws SQLException {
        List<Comment> comments = commentDao.getAllComments();

        comments.stream()
                .forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");

        //Tests add comment
        comment = commentDao.addComment(comment);

        //Test get comment
        Comment comment1 = commentDao.getComment(comment.getCommentId());

        //Asserts comment created is the same as commented retrieved
        assertEquals(comment, comment1);

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("Thomas Jefferson");
        comment2.setComment("Even nicer post! Good job!");

        //Adds second comment to database
        comment2 = commentDao.addComment(comment2);

        //Asserts that there are now 2 comments in database
        assertEquals(2, commentDao.getAllComments().size());

        //Tests delete comment
        commentDao.deleteComment(comment.getCommentId());

        //Asserts there is now 1 comment in database and delete works properly
        assertEquals(1, commentDao.getAllComments().size());

    }

    @Test
    public void getAllComments() {
        //Loads 3 comments to database
        helperCommentDataLoad();

        assertEquals(3, commentDao.getAllComments().size());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");

        //Adds one comment to db
        comment = commentDao.addComment(comment);

        comment.setCreateDate(LocalDate.of(2019, 8, 21));
        comment.setCommenterName("Alexander Hamilton");
        comment.setComment("This is actually my first and only comment!");

        //Updates previously added comment
        commentDao.updateComment(comment);

        //Gets newly updated comment
        Comment comment1 = commentDao.getComment(comment.getCommentId());

        //Asserts the comment was updated in db
        assertEquals(comment, comment1);


    }

    @Test
    public void getAllCommentsForPost() {
        //Loads three comments to db including two comments for Post with ID: 1
        helperCommentDataLoad();
        assertEquals(2, commentDao.getAllCommentsForPost(1).size());

        assertEquals(1, commentDao.getAllCommentsForPost(2).size());
    }

    private void helperCommentDataLoad() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Thomas Jefferson");
        comment.setComment("Nice post mate!");
        comment = commentDao.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.now());
        comment1.setCommenterName("Ben Franklin");
        comment1.setComment("Wicked technology!");
        comment1 = commentDao.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("Thomas Jefferson");
        comment2.setComment("Even nicer post! Good job!");
        comment2 = commentDao.addComment(comment2);
    }

}