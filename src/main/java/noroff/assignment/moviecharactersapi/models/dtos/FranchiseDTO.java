package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

import java.util.Set;

/**
 * DTO includes all Franchise columns, relations minimized to include just their id.
 */
@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<IdDTO> movies;
}
