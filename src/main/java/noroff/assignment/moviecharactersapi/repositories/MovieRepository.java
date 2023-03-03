package noroff.assignment.moviecharactersapi.repositories;

import noroff.assignment.moviecharactersapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
