package ru.trial.assignments.urlshortener.reports.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsResponse {

    @NotNull(message = "Short link cannot be null")
    private String shortLink;

    @NotNull(message = "Original link cannot be null")
    private String originalLink;

    @NotNull(message = "Count value cannot be null")
    private Long count;

    private int rank;
}
