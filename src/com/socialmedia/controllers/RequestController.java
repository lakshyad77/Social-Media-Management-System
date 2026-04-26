package com.socialmedia.controllers;
import com.socialmedia.models.*;
import com.socialmedia.services.*;

public class RequestController {
    private RequestService service = new RequestService();

    public void sendFriendRequest(User sender, User receiver) {
        service.sendRequest(sender, receiver);
    }
}
