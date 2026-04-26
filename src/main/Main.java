package main;

import models.User;
import services.SocialMediaService;
import controllers.SocialMediaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        User user = new User(username);
        SocialMediaService socialMediaService = new SocialMediaService(user);
        SocialMediaController controller = new SocialMediaController(socialMediaService);
        controller.start();
    }
}
