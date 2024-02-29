package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.DataSavingException;

public class UserRepository {
    private final Set<User> users = new HashSet<>();

    public void saveUser(User user) throws DataSavingException {
        String fileName = String.format("data/%s.txt", user.getLastName());
        StringBuilder sb = new StringBuilder();
        sb.append(user.getLastName());
        sb.append(" ");
        sb.append(user.getFirstName());
        sb.append(" ");
        sb.append(user.getMiddleName());
        sb.append(" ");
        sb.append(user.getBirthDate());
        sb.append(" ");
        sb.append(user.getPhoneNumber());
        sb.append(" ");
        sb.append(user.getGender());
        sb.append("\n");
        createDataFolder();

        try (FileWriter fw = new FileWriter(fileName, true);) {
            createDataFolder();
            fw.write(sb.toString());
        } catch (IOException e) {
            throw new DataSavingException(e);
        }
    }

    private void createDataFolder() {
        File path = new File("data");
        if (!path.exists()) {
            path.mkdirs();
        }
    }
}