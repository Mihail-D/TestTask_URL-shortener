package ru.trial.assignments.urlshortener.link.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkResponse {

    @NotNull(message = "Original link cannot be null")
    private String originalLink;

    public LinkResponse(String originalLink) {
        this.originalLink = originalLink;
    }
}
