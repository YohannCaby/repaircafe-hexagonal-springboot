package fr.ycaby.repaircafe.core.exception;

public class DeviceAlreadyPresentException extends RuntimeException{
    public DeviceAlreadyPresentException(String message) {
        super(message);
    }
}
