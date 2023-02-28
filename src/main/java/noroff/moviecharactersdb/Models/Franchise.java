package noroff.moviecharactersdb.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
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
