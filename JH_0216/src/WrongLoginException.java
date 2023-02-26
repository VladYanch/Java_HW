public class WrongLoginException extends Exception {
    private java.lang.Exception Exception;

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
