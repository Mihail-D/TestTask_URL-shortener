package ru.trial.assignments.urlshortener.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.trial.assignments.urlshortener.link.model.Link;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByOriginalLink(String originalLink);

    Optional<Link> findByShortLink(String shortLink);

    @Query("SELECT l FROM Link l ORDER BY l.count DESC")
    List<Link> findTop3Links();
}
