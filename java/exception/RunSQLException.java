package exception;

public class RunSQLException extends RuntimeException {
    public RunSQLException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message);
    }
}
