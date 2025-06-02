package bookexample.ch11;

public class NotExistIDException extends Exception {
    public NotExistIDException() {}
    public NotExistIDException(String message) {
        //_________________________________
        super(message);
    }
}
