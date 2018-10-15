package com.atproj.bullsandcows.exceptions;

public class DifferentLengthException extends Exception {
    public DifferentLengthException(String message) {
        super("DifferentLengthException: " + message);
    }
}
