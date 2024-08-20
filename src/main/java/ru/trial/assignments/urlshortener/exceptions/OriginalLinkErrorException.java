package ru.trial.assignments.urlshortener.exceptions;

public class OriginalLinkErrorException extends RuntimeException {

    public OriginalLinkErrorException(String message) {
        super(message);
    }
}
