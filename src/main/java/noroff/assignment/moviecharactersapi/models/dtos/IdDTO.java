package noroff.assignment.moviecharactersapi.models.dtos;

import lombok.Data;

@Data
public class IdDTO {
    private int id;
    public IdDTO(int id){
        this.id=id;
    }
}
