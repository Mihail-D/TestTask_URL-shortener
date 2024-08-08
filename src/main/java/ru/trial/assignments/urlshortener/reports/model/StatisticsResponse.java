package ru.trial.assignments.urlshortener.reports.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsResponse {

    private String shortLink;

    private String originalLink;

    private Long count;

    private int rank;
}
