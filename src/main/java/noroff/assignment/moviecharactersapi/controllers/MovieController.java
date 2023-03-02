package noroff.assignment.moviecharactersapi.controllers;

import noroff.assignment.moviecharactersapi.mappers.CharacterMapper;
import noroff.assignment.moviecharactersapi.mappers.MovieMapper;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import noroff.assignment.moviecharactersapi.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final CharacterMapper characterMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper, CharacterMapper characterMapper) {

        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }

    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity<Collection<MovieDTO>> getAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(movieService.findAll());
        return ResponseEntity.ok(movies);
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/movies/1
    public ResponseEntity<MovieDTO> getById(@PathVariable int id) {
        MovieDTO movie = movieMapper.movieToMovieDto(movieService.findById(id));
        return ResponseEntity.ok(movie);
    }

    @PostMapping // POST: localhost:8080/api/v1/movies
    public ResponseEntity add(@RequestBody MovieDTO movieDTO) {
        Movie movie = movieService.add(movieMapper.movieDtoToMovie(movieDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/movies/1
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDtoToMovie(movieDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movies/1
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{movieId}/characters") // PUT: localhost:8080/api/v1/movies/1/characters
    public ResponseEntity updateCharacters(@RequestBody int[] characterIds, @PathVariable int movieId) {
        movieService.updateCharacters(movieId, characterIds);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/characters") // GET: localhost:8080/api/v1/movies/1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters(@PathVariable int id) {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(movieService.getCharacters(id));
        return ResponseEntity.ok(characters);
    }


}
