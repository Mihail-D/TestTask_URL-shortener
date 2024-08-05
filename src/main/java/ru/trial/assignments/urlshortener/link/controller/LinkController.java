package ru.trial.assignments.urlshortener.link.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.link.model.LinkRequest;
import ru.trial.assignments.urlshortener.link.service.LinkService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping()
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> createLink(@RequestBody LinkRequest linkRequest) {
        String originalLink = linkRequest.getOriginalLink();
        Optional<Link> existingLink = linkService.findByOriginalLink(originalLink);

        if (existingLink.isPresent()) {
            return ResponseEntity.status(409).body(originalLink);
        }

        String shortLink = "/l/"+linkService.saveLink(originalLink);
        return ResponseEntity.ok(shortLink);
    }

    @GetMapping("/l/{shortLink}")
    public ResponseEntity<String> redirectToOriginalLink(@PathVariable String shortLink) {
        Optional<Link> link = linkService.findByShortLink(shortLink);

        return link.map(value -> ResponseEntity.ok(value.getOriginalLink())).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
