package com.socialmedia.services;
import com.socialmedia.models.*;

public class CommentService {
    public void addComment(Post post, Comment comment) {
        post.addComment(comment);
    }
}
