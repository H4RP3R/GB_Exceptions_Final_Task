package util;

import java.util.Arrays;
import java.util.List;

import core.User;
import exceptions.UnconventionalValuesException;
import exceptions.WrongBirthDateFormatException;
import exceptions.WrongDataAmountException;
import exceptions.WrongPhoneNumberFormatException;

public class UserDataParser {
    public static User parse(String userData) throws Exception {

        List<String> dataList = Arrays.asList(userData.split(" "));
        if (dataList.size() != 6) {
            throw new WrongDataAmountException();
        }

        // Name
        String lastName = dataList.get(0);
        String firstName = dataList.get(1);
        String secondName = dataList.get(2);

        // BirthDate
        String regex = "\\d{2}\\.\\d{2}\\.\\d{4}";
        String birthDate = dataList.get(3);
        if (!birthDate.matches(regex)) {
            throw new WrongBirthDateFormatException();
        }

        List<String> strNumbers = Arrays.asList(birthDate.split("\\."));
        int firstNumber = Integer.parseInt(strNumbers.get(0));
        if (firstNumber < 1 || firstNumber > 31) {
            throw new WrongBirthDateFormatException();
        }
        int secondNumber = Integer.parseInt(strNumbers.get(1));
        if (secondNumber < 1 || secondNumber > 12) {
            throw new WrongBirthDateFormatException();
        }

        // Phone
        long phoneNumber;

        try {
            phoneNumber = Math.abs(Long.parseLong(dataList.get(4)));
        } catch (NumberFormatException e) {
            throw new WrongPhoneNumberFormatException();
        }

        // Gender
        char gender = dataList.get(5).toLowerCase().charAt(0);
        if (gender != 'f' && gender != 'm') {
            throw new UnconventionalValuesException();
        }

        return new User(firstName, secondName, lastName, birthDate, phoneNumber, gender);
    }

}
