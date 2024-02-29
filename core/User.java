package core;

import java.util.Objects;

public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public User(String firstName, String middleName, String lastName, String birthDate, long phoneNumber, char gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s.%s. %s\t%s (%s)", firstName.charAt(0), middleName.charAt(0),
                lastName, phoneNumber, birthDate, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User u = (User) obj;
        return firstName.equals(u.firstName) && middleName.equals(u.middleName) && lastName.equals(u.lastName) &&
                birthDate.equals(u.birthDate) && phoneNumber == u.phoneNumber && gender == u.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, birthDate, phoneNumber, gender);
    }
}