package models;

public class Comment {
    private String content;
    private User user;

    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
    }

    @Override
    public String toString() {
        return user.getUsername() + ": " + content;
    }
}