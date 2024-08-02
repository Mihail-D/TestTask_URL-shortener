package ru.trial.assignments.urlshortener.link.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.link.service.LinkService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/generate")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<Link> createLink(@RequestBody Link link) {
        log.info("Received request to create link: {}", link);
        Optional<Link> existingLink = linkService.findByOriginalLink(link.getOriginalLink());
        if (existingLink.isPresent()) {
            log.warn("Link already exists: {}", existingLink.get());
            return ResponseEntity.status(409).body(existingLink.get());
        }
        Link savedLink = linkService.saveLink(link);
        log.info("Link saved successfully: {}", savedLink);
        return ResponseEntity.ok(savedLink);
    }
}
