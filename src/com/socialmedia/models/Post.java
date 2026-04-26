package com.socialmedia.models;

import java.util.*;

public class Post {
    private String content;
    private User author;
    private List<Comment> comments;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}