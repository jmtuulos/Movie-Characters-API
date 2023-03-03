package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Movie;

import java.util.Collection;


public interface MovieService extends CrudService<Movie, Integer> {
    /**
     * Updates the characters of a movie
     * @param movieId ID of the movie to update
     * @param characterIds Array of character IDs to add to the movie
     */
    void updateCharacters(int movieId, int[] characterIds);

    /**
     * Gets all characters of a movie
     * @param movieId ID of the movie
     * @return collection of characters
     */
    Collection<Character> getCharacters(int movieId);
}
