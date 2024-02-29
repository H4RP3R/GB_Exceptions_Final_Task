package exceptions;

public class UnconventionalValuesException extends Exception {
    public UnconventionalValuesException() {
        super("Wrong gender. Two options available 'm' and 'f'.");
    }
}
