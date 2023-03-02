package noroff.assignment.moviecharactersapi.repositories;

import noroff.assignment.moviecharactersapi.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    Optional<List<Character>> findAllByMovies_Id(int movieId);

    Optional<List<Character>> findAllByMoviesFranchiseId(int franchiseId);
}
