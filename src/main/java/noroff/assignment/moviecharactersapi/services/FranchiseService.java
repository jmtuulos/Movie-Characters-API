package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.Character;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateMovies(int franchiseId, int[] movieIds);

    Collection<Movie> getMovies(int franchiseId);

    Collection<Character> getCharacters(int franchiseId);
}
