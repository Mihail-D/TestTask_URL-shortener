package ru.trial.assignments.urlshortener.link.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shortener_db")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Original link cannot be null")
    @JsonProperty("originalLink")
    @Column(name = "original_link", nullable = false, unique = true)
    private String originalLink;

    @NotNull(message = "Short link cannot be null")
    @JsonProperty("shortLink")
    @Column(name = "short_link", nullable = false, unique = true)
    private String shortLink;

    @NotNull(message = "Count value cannot be null")
    @JsonProperty("count")
    @Column(name = "count")
    private Long count;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Link link = (Link) o;
        return getId().equals(link.getId()) && getOriginalLink().equals(link.getOriginalLink()) && getShortLink().equals(link.getShortLink());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getOriginalLink().hashCode();
        result = 31 * result + getShortLink().hashCode();
        return result;
    }
}
