package ru.trial.assignments.urlshortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOriginalLinkErrorException(final OriginalLinkErrorException e) {
        return new ErrorResponse(String.format("Original link validation error: %s", e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleShortLinkErrorException(final ShortLinkErrorException e) {
        return new ErrorResponse(String.format("Short link validation error: %s", e.getMessage()));
    }
}
