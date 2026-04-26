package com.socialmedia.services;
import com.socialmedia.models.*;

public class PostService {
    public Post createPost(User author, String content) {
        return new Post(content, author);
    }
}