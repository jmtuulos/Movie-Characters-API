package noroff.assignment.moviecharactersapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "movie_title", length = 100)
    private String title;
    @Column(name = "movie_genre", length = 100)
    private String genre;
    @Column(name = "published_year")
    private Integer year;
    private String director;
    private String photoUrl;
    private String trailerUrl;

    @ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    @ManyToOne
    private Franchise franchise;
}