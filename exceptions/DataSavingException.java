package exceptions;

import java.io.IOException;

public class DataSavingException extends IOException {
    public DataSavingException(Exception e) {
        super("Can't save data: " + e.toString());
    }
}
