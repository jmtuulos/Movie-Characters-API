package noroff.assignment.moviecharactersapi.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Set;

public class Franchise {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private Set<Movie> movies;

    public Set<Movie> getMovies() {
        return movies;
    }
}
