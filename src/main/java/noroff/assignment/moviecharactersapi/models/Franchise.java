package noroff.assignment.moviecharactersapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "franchise_name", length = 100)
    private String name;
    private String description;
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
