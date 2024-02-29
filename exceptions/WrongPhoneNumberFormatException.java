package exceptions;

public class WrongPhoneNumberFormatException extends Exception {
    public WrongPhoneNumberFormatException() {
        super("Incorrect phone number format. Must be a number without characters and spaces.");
    }
}
