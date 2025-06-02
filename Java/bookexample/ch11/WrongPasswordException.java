package bookexample.ch11;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {}
    public WrongPasswordException(String message) {
        //_________________________________
        super(message);
    }
}
