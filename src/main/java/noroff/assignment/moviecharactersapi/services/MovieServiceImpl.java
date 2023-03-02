package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.MovieNotFoundException;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.repositories.CharacterRepository;
import noroff.assignment.moviecharactersapi.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
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
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
        List<Character> characters = characterRepository.findAllById(Arrays.stream(characterId).boxed().collect(Collectors.toList()));
        movie.setCharacters(new HashSet<>(characters));
        movieRepository.save(movie);
    }

}
