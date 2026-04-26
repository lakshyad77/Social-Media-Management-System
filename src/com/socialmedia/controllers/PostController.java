package com.socialmedia.controllers;
import com.socialmedia.models.*;
import com.socialmedia.services.*;

public class PostController {
    private PostService postService = new PostService();
    private CommentService commentService = new CommentService();

    public Post createPost(User author, String content) {
        return postService.createPost(author, content);
    }

    public void addComment(Post post, Comment comment) {
        commentService.addComment(post, comment);
    }
}

