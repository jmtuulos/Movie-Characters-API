package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<IdDTO> movies;
}
