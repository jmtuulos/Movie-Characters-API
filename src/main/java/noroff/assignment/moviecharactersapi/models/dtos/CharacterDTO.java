package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;
import noroff.assignment.moviecharactersapi.models.Movie;

import java.util.Set;

@Data
public class CharacterDTO {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String photoUrl;
    private Set<Movie> movies;
}
