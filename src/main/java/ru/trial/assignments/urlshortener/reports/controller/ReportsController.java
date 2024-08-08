package ru.trial.assignments.urlshortener.reports.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trial.assignments.urlshortener.reports.model.StatisticsResponse;
import ru.trial.assignments.urlshortener.reports.service.ReportsService;

@Slf4j
@RestController
@RequestMapping()
public class ReportsController {

    ReportsService reportsService;

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping("/stats/{shortLink}")
    public ResponseEntity<StatisticsResponse> redirectToOriginalLink(@PathVariable String shortLink) {
        StatisticsResponse response = reportsService.getLinkInTop(shortLink);
        return ResponseEntity.ok(response);
    }
}
