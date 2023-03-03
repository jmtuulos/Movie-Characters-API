package noroff.assignment.moviecharactersapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import noroff.assignment.moviecharactersapi.customexceptions.ApiErrorResponse;
import noroff.assignment.moviecharactersapi.mappers.CharacterMapper;
import noroff.assignment.moviecharactersapi.mappers.MovieMapper;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import noroff.assignment.moviecharactersapi.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * API controller handling movie operations on "api/v1/movies"
 */
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

    @Operation(summary = "Get all movies")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Movies found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))
                    )
            }
    )
    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity<Collection<MovieDTO>> getAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(movieService.findAll());
        return ResponseEntity.ok(movies);
    }

    @Operation(summary = "Get a movie by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Movie found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @GetMapping("{id}") // GET: localhost:8080/api/v1/movies/1
    public ResponseEntity<MovieDTO> getById(@PathVariable int id) {
        MovieDTO movie = movieMapper.movieToMovieDto(movieService.findById(id));
        return ResponseEntity.ok(movie);
    }

    @Operation(summary = "Add a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Movie added"),
                    @ApiResponse(responseCode = "400", description = "Wrong format", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @PostMapping // POST: localhost:8080/api/v1/movies
    public ResponseEntity<?> add(@RequestBody MovieDTO movieDTO) {
        movieService.add(movieMapper.movieDtoToMovie(movieDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Movie updated"),
                    @ApiResponse(responseCode = "400", description = "Wrong format, MovieId must exist", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/movies/1
    public ResponseEntity<?> update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDtoToMovie(movieDTO));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Movie deleted"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movies/1
    public ResponseEntity<?> delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update characters in a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Updated characters"),
                    @ApiResponse(responseCode = "400", description = "Wrong format, MovieId and CharacterIds must exist", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Movie or Characters not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @PatchMapping("{id}/characters") // PATCH: localhost:8080/api/v1/movies/1/characters
    public ResponseEntity<?> updateCharacters(@RequestBody int[] characterIds, @PathVariable int id) {
        movieService.updateCharacters(id, characterIds);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Get all characters in a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            description = "Found the characters",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @GetMapping("{id}/characters") // GET: localhost:8080/api/v1/movies/1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters(@PathVariable int id) {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(movieService.getCharacters(id));
        return ResponseEntity.ok(characters);
    }

}
