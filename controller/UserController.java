package controller;

import util.UserDataParser;
import java.util.Set;

import core.User;
import core.UserRepository;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String inputData) throws Exception {
        User user = UserDataParser.parse(inputData);
        this.userRepository.saveUser(user);
    }

    public Set<User> listUsers() throws Exception {
        return userRepository.getUsers();
    }
}
