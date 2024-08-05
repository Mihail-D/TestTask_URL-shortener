package ru.trial.assignments.urlshortener.link.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.link.repository.LinkRepository;
import ru.trial.assignments.urlshortener.link.utils.UrlConverter;

import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String saveLink(String originalUrl) {
        String shortUrl = UrlConverter.encodeUrl(originalUrl);
        Link link = new Link();
        link.setOriginalLink(originalUrl);
        link.setShortLink(shortUrl);

        linkRepository.save(link);

        return link.getShortLink();
    }

    public Optional<Link> findByOriginalLink(String originalLink) {
        return linkRepository.findByOriginalLink(originalLink);
    }

}
