package controllers;

import models.User;
import services.SocialMediaService;

import java.util.Scanner;

public class SocialMediaController {
    private SocialMediaService socialMediaService;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSocial Media Platform Menu:");
            System.out.println("1. Add Post");
            System.out.println("2. Add Friend");
            System.out.println("3. View Profile");
            System.out.println("4. Add Comment to Post");
            System.out.println("5. Share Post");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter post content: ");
                    String postContent = scanner.nextLine();
                    socialMediaService.addPost(postContent);
                    break;
                case 2:
                    System.out.print("Enter friend's username: ");
                    String friendUsername = scanner.nextLine();
                    User friend = new User(friendUsername);
                    socialMediaService.addFriend(friend);
                    break;
                case 3:
                    socialMediaService.viewProfile();
                    break;
                case 4:
                    System.out.print("Enter post index to comment on (0 for first post, etc.): ");
                    int postIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter comment content: ");
                    String commentContent = scanner.nextLine();
                    socialMediaService.addComment(postIndex, commentContent);
                    break;
                case 5:
                    System.out.print("Enter post index to share (0 for first post, etc.): ");
                    int shareIndex = scanner.nextInt();
                    if (shareIndex < 0 || shareIndex >= socialMediaService.getCurrentUser().getPosts().size()) {
                        System.out.println("Invalid post index.");
                    } else {
                        socialMediaService.getCurrentUser().getPosts().get(shareIndex).share();
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
       