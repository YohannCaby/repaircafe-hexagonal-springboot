package fr.ycaby.repaircafe.core.exception;

public class MemberAlreadyPresentException extends RuntimeException{
    public MemberAlreadyPresentException(String message) {
        super(message);
    }
}
