package bg.softuni.Pathfinder.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message, Throwable exception) {
        super(message, exception);
    }
}
