package ru.trial.assignments.urlshortener.link.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkResponse {

    private String originalLink;

    public LinkResponse(String originalLink) {
        this.originalLink = originalLink;
    }
}
