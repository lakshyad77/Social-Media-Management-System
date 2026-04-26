package models;
import services.*;
import java.util.ArrayList;
import java.util.List;

public class Post implements Shareable {
    private String content;
    private List<Comment> comments;

    public Post(String content) {
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post: " + content + " | Comments: " + comments.size();
    }

    @Override
    public void share() {
        System.out.println("Sharing post: " + content);
    }
}
