package ru.trial.assignments.urlshortener.utils;

import lombok.experimental.UtilityClass;
import ru.trial.assignments.urlshortener.exceptions.OriginalLinkErrorException;
import ru.trial.assignments.urlshortener.exceptions.ShortLinkErrorException;

@UtilityClass
public class Validator {

    public void validateShortLink(String shortLink) {
        String regex = "^[a-z]+\\d{2}\\.ly$";
        if (!shortLink.matches(regex)) {
            throw new ShortLinkErrorException("Invalid short link: " + shortLink);
        }
    }

    public void validateOriginalLink(String originalLink) {
        String regex = "^(http|https)://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w.-]*$";
        if (!originalLink.matches(regex)) {
            throw new OriginalLinkErrorException("Invalid original link: " + originalLink);
        }
    }

}
