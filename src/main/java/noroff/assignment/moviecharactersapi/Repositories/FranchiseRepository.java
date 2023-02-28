package noroff.assignment.moviecharactersapi.Repositories;

import noroff.assignment.moviecharactersapi.Models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
