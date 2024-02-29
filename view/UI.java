package view;

import java.util.Scanner;

import controller.UserController;

public class UI {
    public void mainMenu(Scanner iScanner, UserController userController) {
        while (true) {
            System.out.println("\n1. Add user.");
            System.out.println("2. List users.");
            System.out.println("3. Exit.");

            System.out.print("> ");
            String userInput = iScanner.nextLine().trim();
            switch (userInput) {
                case "1":
                    System.out.println("\nEnter a string like:");
                    System.out.print(
                            "<Last name> <First name> <Middle name> <birth_date> <telephone_number> <gender>\n> ");
                    String inputData = iScanner.nextLine().trim();
                    try {
                        userController.saveUser(inputData);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case "2":

                    break;

                case "3":
                    iScanner.close();
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}
