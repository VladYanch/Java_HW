public class WrongPasswordException extends Exception{
    private java.lang.Exception Exception;

    private WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
