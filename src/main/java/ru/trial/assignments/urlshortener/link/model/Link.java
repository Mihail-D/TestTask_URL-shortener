package ru.trial.assignments.urlshortener.link.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shortener_db")
public class Link {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_link", nullable = false, unique = true)
    private String originalLink;

    @Column(name = "short_link", nullable = false, unique = true)
    private String shortLink;


}
