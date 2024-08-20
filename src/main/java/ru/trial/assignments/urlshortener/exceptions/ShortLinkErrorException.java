package ru.trial.assignments.urlshortener.exceptions;

public class ShortLinkErrorException extends RuntimeException {

    public ShortLinkErrorException(String message) {
        super(message);
    }
}
