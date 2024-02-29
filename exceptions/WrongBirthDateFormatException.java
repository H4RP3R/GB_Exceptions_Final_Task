package exceptions;

public class WrongBirthDateFormatException extends Exception {
    public WrongBirthDateFormatException() {
        super("Incorrect birth date format. Must match 'dd.mm.yyyy'");
    }
}
