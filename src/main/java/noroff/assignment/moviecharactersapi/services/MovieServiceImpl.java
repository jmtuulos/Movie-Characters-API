package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public Movie findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    @Override
    public Movie add(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Movie entity) {

    }

    @Override
    public void updateCharacters(int movieId, int[] characterId) {

    }

    @Override
    public Collection<Character> getCharacters(int movieId) {

        return List.of(new Character[0]);
    }
}
