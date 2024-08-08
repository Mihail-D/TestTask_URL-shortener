package ru.trial.assignments.urlshortener.reports.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.trial.assignments.urlshortener.reports.model.StatisticsResponse;
import ru.trial.assignments.urlshortener.reports.service.ReportsService;

import java.util.List;

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

    @GetMapping("/stats")
    public ResponseEntity<List<StatisticsResponse>> getStats(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int count) {

        if (count > 100) {
            count = 100;
        }

        List<StatisticsResponse> stats = reportsService.getPaginatedStats(page, count);
        for (int i = 0; i < stats.size(); i++) {
            stats.get(i).setRank((page - 1) * count + i + 1);
        }

        return ResponseEntity.ok(stats);
    }
}
