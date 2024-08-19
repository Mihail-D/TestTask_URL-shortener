package ru.trial.assignments.urlshortener.link.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkRequest {

    @NotNull(message = "Original link cannot be null")
    private String originalLink;

}
