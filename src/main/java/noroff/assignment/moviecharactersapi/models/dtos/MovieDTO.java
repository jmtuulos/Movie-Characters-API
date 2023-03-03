package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

import java.util.Set;

/**
 * DTO includes all Movie columns, relations minimized to include just their id.
 */
@Data
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String photoUrl;
    private String trailerUrl;
    private Set<IdDTO> characters;
    private Integer franchise;
}
