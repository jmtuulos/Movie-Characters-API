package noroff.assignment.moviecharactersapi.models;

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
    private String fullName;
    private String alias;
    private String gender;
    private String photoUrl;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}