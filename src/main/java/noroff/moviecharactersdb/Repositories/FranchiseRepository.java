package noroff.moviecharactersdb.Repositories;

import noroff.moviecharactersdb.Models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
