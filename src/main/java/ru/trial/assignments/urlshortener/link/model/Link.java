package ru.trial.assignments.urlshortener.link.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shortener_db")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("originalLink")
    @Column(name = "original_link", nullable = false, unique = true)
    private String originalLink;

    @JsonProperty("shortLink")
    @Column(name = "short_link", nullable = false, unique = true)
    private String shortLink;

    @NonNull
    @JsonProperty("count")
    @Column(name = "count")
    private Long count;
}
