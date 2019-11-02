package com.trilogyed.stwitter.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;
    List<Comment> comments = new ArrayList<>();

    public PostViewModel(){}

    public PostViewModel(Post post) {
        this.postId = post.getPostId();
        this.postDate = post.getPostDate();
        this.posterName = post.getPosterName();
        this.post = post.getPost();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postID) {
        this.postId = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return getPostId() == that.getPostId() &&
                getPostDate().equals(that.getPostDate()) &&
                getPosterName().equals(that.getPosterName()) &&
                getPost().equals(that.getPost()) &&
                getComments().equals(that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostDate(), getPosterName(), getPost(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "\n\tPost ID: " + postId +
                ",\n\tPost Date: " + postDate +
                ",\n\tPoster Name: '" + posterName + '\'' +
                ",\n\tPost: '" + post + '\'' +
                ",\n\tComments: " + comments + "\n" +
                '}';
    }
}
