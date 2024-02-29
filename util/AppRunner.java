package util;

import java.util.Scanner;

import controller.UserController;
import core.UserRepository;
import view.UI;

public class AppRunner {
    public static void run() {
        Scanner iScanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);
        UI ui = new UI();
        ui.mainMenu(iScanner, userController);
    }
}
