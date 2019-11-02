package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    private final String INSERT_POST_SQL =
            "insert into post (post_date, poster_name, post) " +
                    "values (?, ?, ?)";

    private final String SELECT_POST_SQL =
            "select * from post where post_id = ?";

    private final String SELECT_ALL_POSTS_SQL =
            "select * from post";

    private final String UPDATE_POST_SQL =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";

    private final String DELETE_POST_SQL =
            "delete from post where post_id = ?";

    private final String SELECT_POSTS_BY_POSTSER_SQL =
            "select * from post where poster_name = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));
        return post;
    }

    @Override
    @Transactional
    public Post addPost(Post post) {
        jdbcTemplate.update(INSERT_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        post.setPostId(id);
        return post;
    }

    @Override
    public Post getPost(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST_SQL, this::mapRowToPost, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS_SQL, this::mapRowToPost);
    }

    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(UPDATE_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostId());
    }

    @Override
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_POST_SQL, id);
    }

    @Override
    public List<Post> getPostsForPoster(String posterName) {
        return jdbcTemplate.query(SELECT_POSTS_BY_POSTSER_SQL, this::mapRowToPost, posterName);
    }
}
