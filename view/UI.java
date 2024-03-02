package view;

import java.util.Scanner;
import java.util.Set;

import controller.UserController;
import core.User;

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
                    System.out.println("\nEnter the values in the recommended order, separated by spaces:");
                    System.out.print(
                            "<last name> <first name> <middle name> <birth_date> <telephone_number> <gender>\n> ");
                    String inputData = iScanner.nextLine().trim();
                    try {
                        userController.saveUser(inputData);
                    } catch (Exception e) {
                        System.err.println(e.getMessage() == null ? "Cant't save data." : e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        Set<User> users = userController.listUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                    } catch (Exception e) {
                        System.err.println("Can't read data.");
                    }
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
