package ru.trial.assignments.urlshortener.link.utils;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class UrlConverter {

    public String encodeUrl(String url) {
        String str = url.replaceAll("https?://|[:/]|[^a-z]", ""); // practicumyandexruprofilejavadeveloper

        Set<Character> uniqueChars = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (uniqueChars.add(c)) {
                result.append(c);
            }
        }

        result.append(TimeCheck.getTimeStamp()).append(".ly");

        return result.toString();
    }
}
