package noroff.assignment.moviecharactersapi.Repositories;

import noroff.assignment.moviecharactersapi.Models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
