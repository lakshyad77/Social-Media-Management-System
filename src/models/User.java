package models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Post> posts;
    private List<Friend> friends;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void viewProfile() {
        System.out.println(":User  " + username);
        System.out.println("Friends: ");
        for (Friend friend : friends) {
            System.out.println("- " + friend.getUsername());
        }
        System.out.println("Posts: ");
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}
