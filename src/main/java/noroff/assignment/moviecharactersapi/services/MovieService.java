package noroff.assignment.moviecharactersapi.services;
import noroff.assignment.moviecharactersapi.models.Movie;



public interface MovieService extends CrudService<Movie, Integer> {
    void updateCharacters(int movieId, int[] characterIds);

//    Collection<Character> getCharacters(int movieId);
}
