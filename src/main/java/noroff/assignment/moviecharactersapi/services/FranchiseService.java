package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.Character;
import java.util.List;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateMovies(int franchiseId, int[] movieIds);

    List<Movie> getMovies(int franchiseId);

    List<Character> getCharacters(int franchiseId);
}
