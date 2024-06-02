package fr.ycaby.repaircafe.core.exception;

public class MemberRoleAlreadyPresentException extends RuntimeException {
    public MemberRoleAlreadyPresentException(String message) {
        super(message);
    }
}
