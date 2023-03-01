package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Franchise;

import java.util.Set;

@Data
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String photoUrl;
    private String trailerUrl;
    private Set<Character> characters;
    private Franchise franchise;
}
