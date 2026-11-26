package com.micancha.exception;

public class ReservaNoDisponibleException extends RuntimeException {
    public ReservaNoDisponibleException (String message) {
        super(message);
    }
}
