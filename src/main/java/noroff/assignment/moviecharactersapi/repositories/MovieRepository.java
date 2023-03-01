package noroff.assignment.moviecharactersapi.repositories;

import noroff.assignment.moviecharactersapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<List<Movie>> findByFranchiseId(Integer integer);
}
