package noroff.assignment.moviecharactersapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import noroff.assignment.moviecharactersapi.mappers.CharacterMapper;
import noroff.assignment.moviecharactersapi.mappers.FranchiseMapper;
import noroff.assignment.moviecharactersapi.mappers.MovieMapper;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.models.dtos.FranchiseDTO;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import noroff.assignment.moviecharactersapi.services.FranchiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;
    private final MovieMapper movieMapper;
    private final CharacterMapper characterMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper, MovieMapper movieMapper, CharacterMapper characterMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }
    @Operation(summary = "Get all franchises")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Franchises not found"),
            }
    )
    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<FranchiseDTO>> getAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(franchiseService.findAll());
        return ResponseEntity.ok(franchises);
    }
    @Operation(summary = "Get franchise by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Franchise not found"),
            }
    )
    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<FranchiseDTO> getById(@PathVariable int id) {
        FranchiseDTO franchise = franchiseMapper.franchiseToFranchiseDto(franchiseService.findById(id));
        return ResponseEntity.ok(franchise);
    }
    @Operation(summary = "Add a new franchise")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Franchise created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Not able to create a franchise"),
            }
    )
    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity add(@RequestBody FranchiseDTO franchiseDTO) {
        Franchise franchise = franchiseService.add(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "Update a franchise")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Franchise updated",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Not able to update the franchise"),
            }
    )
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchises/1
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if (id != franchiseDTO.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Delete franchise by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Franchise deleted"
                    ),
                    @ApiResponse(responseCode = "400", description = "Not able to delete the franchise"),
            }
    )
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/franchises/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Get all movies from franchise")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Franchise not found"),
            }
    )
    @GetMapping("{id}/movies") // GET: localhost:8080/api/v1/franchises/1/movies
    public ResponseEntity<Collection<MovieDTO>> getAllMovies(@PathVariable int id) {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(franchiseService.getMovies(id));
        return ResponseEntity.ok(movies);
    }

    @Operation(summary = "Get all characters from a franchise")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Franchise not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )
    @GetMapping("{id}/characters") // GET: localhost:8080/api/v1/franchises/1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters(@PathVariable int id) {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(franchiseService.getCharacters(id));
        return ResponseEntity.ok(characters);
    }
    @Operation(summary = "Update movies from a franchise")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Movies updated",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
                    @ApiResponse(responseCode = "404", description = "Franchise not found"),
            }
    )
    @PatchMapping("{id}/movies") // PATCH: localhost:8080/api/v1/franchises/1/movies
    public ResponseEntity updateMovies(@RequestBody int[] characterIds, @PathVariable int id) {
        franchiseService.updateMovies(id, characterIds);
        return ResponseEntity.noContent().build();
    }
}
