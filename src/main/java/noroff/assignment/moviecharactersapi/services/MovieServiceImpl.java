package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.MovieNotFoundException;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Collection<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @Override
    public Movie add(Movie entity) {
        Movie movie = movieRepository.save(entity);
        return movie;
    }

    @Override
    public Movie update(Movie entity) {
        Movie movie = movieRepository.save(entity);
        return movie;
    }

    @Override
    public void deleteById(Integer id) {
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            //movie.getCharacters().forEach(c -> c.setMovie(null));
            //todo: remove movie from characters
            movieRepository.delete(movie);
        } else
            logger.warn("No movie exists with ID: " + id);
    }

    @Override
    public void delete(Movie movie) {
        //todo: remove movie from characters
        movieRepository.delete(movie);
    }

    @Override
    public void updateCharacters(int movieId, int[] characterId) {
        //todo
    }

    @Override
    public Collection<Character> getCharacters(int movieId) {
        return findById(movieId).getCharacters();
    }
}
