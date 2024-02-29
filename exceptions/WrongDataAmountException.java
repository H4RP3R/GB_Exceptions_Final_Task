package exceptions;

public class WrongDataAmountException extends Exception {
    public WrongDataAmountException() {
        super("Wrong data amount.");
    }
}
