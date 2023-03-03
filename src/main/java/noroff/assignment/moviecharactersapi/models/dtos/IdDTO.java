package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

/**
 * DTO for presenting an object as a minimized version including just the id field. Example: {id: 1}
 */
@Data
public class IdDTO {
    private int id;
    public IdDTO(int id){
        this.id=id;
    }
}
