package ru.trial.assignments.urlshortener.link.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.link.model.LinkRequest;
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

    @PostMapping()
    public ResponseEntity<String> createLink(@RequestBody LinkRequest linkRequest) {
        String originalLink = linkRequest.getOriginalLink();
        Optional<Link> existingLink = linkService.findByOriginalLink(originalLink);

        if (existingLink.isPresent()) {
            return ResponseEntity.status(409).body(originalLink);
        }

        String shortLink = linkService.saveLink(originalLink);
        return ResponseEntity.ok(shortLink);
    }
}
