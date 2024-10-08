package ru.trial.assignments.urlshortener.link.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.repository.LinkRepository;
import ru.trial.assignments.urlshortener.utils.UrlConverter;
import ru.trial.assignments.urlshortener.utils.Validator;

import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String createShortLink(String originalUrl) {
        Validator.validateOriginalLink(originalUrl);
        String shortUrl = UrlConverter.encodeUrl(originalUrl);
        Link link = new Link();
        link.setOriginalLink(originalUrl);
        link.setShortLink(shortUrl);
        link.setCount(1L);
        linkRepository.save(link);

        return link.getShortLink();
    }


    public Optional<Link> findByShortLink(String shortLink) {
        Validator.validateShortLink(shortLink);
        Link link = linkRepository.findByShortLink(shortLink).orElseThrow();
        link.setCount(link.getCount() + 1);
        linkRepository.save(link);
        return Optional.of(link);
    }

    public Optional<Link> findByOriginalLink(String originalUrl) {
        Validator.validateOriginalLink(originalUrl);
        return linkRepository.findByOriginalLink(originalUrl);
    }

}
