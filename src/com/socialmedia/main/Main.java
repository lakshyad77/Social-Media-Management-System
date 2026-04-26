package com.socialmedia.main;

import com.socialmedia.models.*;
import com.socialmedia.controllers.*;
import com.socialmedia.utils.Database;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RequestController requestController = new RequestController();
        PostController postController = new PostController();

        while (true) {
            try {
                System.out.println("\n=== Social Media Menu ===");
                System.out.println("1. Create Regular User");
                System.out.println("2. Create Admin User");
                System.out.println("3. Send Friend Request");
                System.out.println("4. Create Post");
                System.out.println("5. Comment on Post");
                System.out.println("6. Remove User (Admin Only)");
                System.out.println("7. View All Users");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                    case 2:
                        String id;
                        while (true) {
                            System.out.print("Enter ID: ");
                            id = scanner.nextLine();
                            if (isValidId(id)) break;
                            System.out.println("Invalid ID. Only alphanumeric characters allowed.");
                        }

                        String name;
                        while (true) {
                            System.out.print("Enter Name: ");
                            name = scanner.nextLine();
                            if (isValidUsername(name)) break;
                            System.out.println("Invalid username. Alphabets only.");
                        }

                        String email;
                        while (true) {
                            System.out.print("Enter Email: ");
                            email = scanner.nextLine();
                            if (isValidEmail(email)) break;
                            System.out.println("Invalid Gmail address. Must end with @gmail.com.");
                        }

                        if (choice == 1) {
                            Database.users.add(new RegularUser(id, name, email));
                            System.out.println("Regular user created.");
                        } else {
                            Database.users.add(new AdminUser(id, name, email));
                            System.out.println("Admin user created.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Sender Name: ");
                        String senderName = scanner.nextLine();
                        System.out.print("Enter Receiver Name: ");
                        String receiverName = scanner.nextLine();
                        User sender = findUserByName(senderName);
                        User receiver = findUserByName(receiverName);
                        if (sender != null && receiver != null) {
                            requestController.sendFriendRequest(sender, receiver);
                        } else {
                            System.out.println("User(s) not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Author Name: ");
                        String authorName = scanner.nextLine();
                        User author = findUserByName(authorName);
                        if (author != null) {
                            System.out.print("Enter Post Content: ");
                            String content = scanner.nextLine();
                            Database.posts.add(postController.createPost(author, content));
                            System.out.println("Post created.");
                        } else {
                            System.out.println("Author not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Commenter Name: ");
                        String commenterName = scanner.nextLine();
                        User commenter = findUserByName(commenterName);
                        if (commenter != null && !Database.posts.isEmpty()) {
                            System.out.print("Enter Comment Content: ");
                            String commentContent = scanner.nextLine();
                            Comment comment = new Comment(commentContent, commenter);
                            postController.addComment(Database.posts.get(Database.posts.size() - 1), comment);
                            System.out.println("Comment added to the last post.");
                        } else {
                            System.out.println("Commenter not found or no posts available.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Admin Name: ");
                        String adminName = scanner.nextLine();
                        User admin = findUserByName(adminName);
                        System.out.print("Enter User Name to Remove: ");
                        String removeName = scanner.nextLine();
                        User toRemove = findUserByName(removeName);
                        if (admin instanceof AdminUser && toRemove != null) {
                            ((AdminUser) admin).removeUser(toRemove);
                            Database.users.remove(toRemove);
                        } else {
                            System.out.println("Admin privileges required or user not found.");
                        }
                        break;

                    case 7:
                        System.out.println("\n-- All Users --");
                        for (User user : Database.users) {
                            System.out.println(user.getName() + " (" + user.getClass().getSimpleName() + ")");
                        }
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numeric option.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }								

    private static User findUserByName(String name) {
        for (User user : Database.users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private static boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.+-]+@gmail\\.com$", email);
    }

    private static boolean isValidUsername(String name) {
        return Pattern.matches("^[a-zA-Z]+$", name);
    }

    private static boolean isValidId(String id) {
        return Pattern.matches("^[a-zA-Z0-9]+$", id);
    }
}


