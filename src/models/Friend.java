package models;

public class Friend {
    private User user;

    public Friend(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }
}
