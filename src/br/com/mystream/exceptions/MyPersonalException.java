package br.com.mystream.exceptions;

public class MyPersonalException extends RuntimeException {
    private final String message;

    public MyPersonalException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
