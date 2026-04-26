package com.socialmedia.models;

public class FriendRequest {
    private User sender;
    private User receiver;
    private String status;

    public FriendRequest(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = "Pending";
    }

    public void accept() {
        status = "Accepted";
    }

    public void reject() {
        status = "Rejected";
    }
}