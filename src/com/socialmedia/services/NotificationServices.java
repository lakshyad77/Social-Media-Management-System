package com.socialmedia.services;
import com.socialmedia.models.*;

public class NotificationServices {
    public void notifyUser(User user, String message) {
        user.notify(message);
    }
}

