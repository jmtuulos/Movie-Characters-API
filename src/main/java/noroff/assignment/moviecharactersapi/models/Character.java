package noroff.assignment.moviecharactersapi.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

public class Character {
    public int getId() {
        return id;
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String pictureUrl;

}
