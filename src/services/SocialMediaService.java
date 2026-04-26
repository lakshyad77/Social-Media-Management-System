package services;
import models.Friend;
import models.User;
import models.Post;
import models.Comment;


public class SocialMediaService {
    private User currentUser ;

    public SocialMediaService(User user) {
        this.currentUser  = user;
    }

    public User getCurrentUser () {
        return currentUser ;
    }

    public void addPost(String content) {
        Post post = new Post(content);
        currentUser .addPost(post);
        System.out.println("Post added!");
    }

    public void addFriend(User friend) {
        currentUser .addFriend(new Friend(friend));
        System.out.println("Friend added!");
    }

    public void viewProfile() {
        currentUser .viewProfile();
    }

    public void addComment(int postIndex, String commentContent) {
        if (postIndex < 0 || postIndex >= currentUser .getPosts().size()) {
            System.out.println("Invalid post index.");
            return;
        }
        Comment comment = new Comment(commentContent, currentUser );
        currentUser .getPosts().get(postIndex).addComment(comment);
        System.out.println("Comment added!");
    }
}