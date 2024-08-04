package ru.trial.assignments.urlshortener.link.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("originalLink")
    @Column(name = "original_link", nullable = false, unique = true)
    private String originalLink;

    @JsonProperty("shortLink")
    @Column(name = "short_link", nullable = false, unique = true)
    private String shortLink;


}
