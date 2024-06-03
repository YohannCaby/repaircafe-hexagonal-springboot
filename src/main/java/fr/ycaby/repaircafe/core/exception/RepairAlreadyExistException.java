package fr.ycaby.repaircafe.core.exception;

public class RepairAlreadyExistException extends
        RuntimeException {

    public RepairAlreadyExistException(String message) {
        super(message);
    }
}
