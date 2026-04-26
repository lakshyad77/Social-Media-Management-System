package com.socialmedia.services;
import com.socialmedia.models.*;

public class RequestService {
    public void sendRequest(User sender, User receiver) {
        FriendRequest request = new FriendRequest(sender, receiver);
        sender.notify("You sent a request to " + receiver.getName());
        receiver.notify("You received a request from " + sender.getName());
    }

    public void respondToRequest(FriendRequest request, boolean accept) {
        if (accept) request.accept();
        else request.reject();
    }
}
