package com.socialmedia.models;
public abstract class User implements Notifiable {
    protected String id;
    protected String name;
    protected String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }


    public abstract void viewProfile();
    public abstract void sendRequest(User user);

    @Override
    public void notify(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }
}