package noroff.assignment.moviecharactersapi.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

public class Movie {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String pictureUrl;
    private String trailerUrl;

    public void setFranchise(Movie m) {
    }
}
