package ru.trial.assignments.urlshortener.link.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trial.assignments.urlshortener.link.model.Link;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByOriginalLink(String originalLink);

    Optional<Link> findByShortLink(String shortLink);
}
