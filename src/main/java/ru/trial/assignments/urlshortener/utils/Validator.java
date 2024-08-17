package ru.trial.assignments.urlshortener.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {

    public boolean validateUrl(String url) {
        return url.matches("^(http|https)://.*$");
    }

    public boolean validateShortLink(String shortLink) {
        return shortLink.matches("^[a-zA-Z0-9]*$");
    }

    public boolean validateOriginalLink(String originalLink) {
        return originalLink.matches("^(http|https)://.*$");
    }

    public boolean validateCount(Long count) {
        return count >= 0;
    }

    public boolean validateRank(int rank) {
        return rank >= 0;
    }

    public boolean validateTimeStamp(String timeStamp) {
        return timeStamp.matches("^[0-9]*$");
    }

    public boolean validateId(Long id) {
        return id >= 0;
    }


}
