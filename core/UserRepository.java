package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exceptions.DataSavingException;
import util.UserDataParser;

public class UserRepository {
    private final Set<User> users;
    private final String dataPath;

    public UserRepository() {
        this.users = new HashSet<>();
        this.dataPath = "data";
    }

    public void saveUser(User user) throws Exception {
        createDataFolder();
        readAllUsers();

        if (users.contains(user)) {
            throw new DataSavingException("User already exists.");
        }

        String fileName = String.format("%s%s%s.txt", dataPath, File.separator, user.getLastName());
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

        try (FileWriter fw = new FileWriter(fileName, true);) {
            createDataFolder();
            fw.write(sb.toString());
        } catch (IOException e) {
            throw new DataSavingException("Can't save data", e);
        }
    }

    public Set<User> getUsers() throws Exception {
        readAllUsers();
        return users;
    }

    public void readAllUsers() throws Exception {
        Set<String> filesNames = Stream.of(new File(dataPath).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

        for (String fileName : filesNames) {
            Path path = Paths.get(dataPath, fileName);
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    User user = UserDataParser.parse(line);
                    this.users.add(user);
                    line = br.readLine();
                }
            }
        }
    }

    private void createDataFolder() {
        File path = new File(dataPath);
        if (!path.exists()) {
            path.mkdirs();
        }
    }
}