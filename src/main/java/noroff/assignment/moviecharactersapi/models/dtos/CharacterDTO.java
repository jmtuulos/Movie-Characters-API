package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

import java.util.Set;

/**
 * DTO includes all Character columns, relations minimized to include just their id.
 */
@Data
public class CharacterDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String photoUrl;
    private Set<IdDTO> movies;
}
