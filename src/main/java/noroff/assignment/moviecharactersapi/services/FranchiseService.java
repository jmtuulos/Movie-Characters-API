package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.Character;

import java.util.List;
import java.util.Set;

public interface FranchiseService extends CrudService<Franchise, Integer> {

    /**
     * Updates the movies of a franchise
     * @param franchiseId The id of the franchise
     * @param movieIds The ids of the movies
     */
    void updateMovies(int franchiseId, int[] movieIds);

    /**
     * Gets all movies of a franchise
     * @param franchiseId The id of the franchise
     * @return set of movies
     */
    Set<Movie> getMovies(int franchiseId);

    /**
     * Gets all characters of the movies in a franchise
     * @param franchiseId The id of the franchise
     * @return list of characters
     */
    List<Character> getCharacters(int franchiseId);
}
