package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class CharacterDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String photoUrl;
    private Set<Integer> movies;
}
