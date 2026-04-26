package com.socialmedia.models;

public class AdminUser extends User {
    public AdminUser(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void viewProfile() {
        System.out.println("[Admin] Viewing profile of: " + name);
    }

    @Override
    public void sendRequest(User user) {
        System.out.println("[Admin] " + name + " sent a friend request to " + user.name);
    }

    public void removeUser(User user) {
        System.out.println("[Admin] " + name + " removed user: " + user.name);
    }
}
