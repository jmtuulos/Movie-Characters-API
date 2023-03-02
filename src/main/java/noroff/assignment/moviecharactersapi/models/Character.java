package noroff.assignment.moviecharactersapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String name;
    private String alias;
    private String gender;
    private String photoUrl;
    @JsonIgnore
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}