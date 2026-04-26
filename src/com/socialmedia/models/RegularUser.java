// 3. RegularUser class
package com.socialmedia.models;

public class RegularUser extends User {
    public RegularUser(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void viewProfile() {
        System.out.println("Viewing profile of: " + name);
    }

    @Override
    public void sendRequest(User user) {
        System.out.println(name + " sent a friend request to " + user.name);
    }
}
