package exceptions;

import java.io.IOException;

public class DataSavingException extends IOException {
    public DataSavingException(String msg, Exception e) {
        super(String.format("%s: %s", msg, e.getMessage()));
        e.printStackTrace(System.err);
    }

    public DataSavingException(String msg) {
        super(msg);
    }
}
