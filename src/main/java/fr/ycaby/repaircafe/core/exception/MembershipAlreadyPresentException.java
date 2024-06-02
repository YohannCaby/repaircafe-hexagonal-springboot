package fr.ycaby.repaircafe.core.exception;

public class MembershipAlreadyPresentException extends RuntimeException {
    public MembershipAlreadyPresentException(String message) {
        super(message);
    }
}
