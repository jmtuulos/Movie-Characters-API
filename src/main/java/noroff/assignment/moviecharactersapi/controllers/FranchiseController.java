package noroff.assignment.moviecharactersapi.controllers;

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

import java.net.URI;
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

    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<FranchiseDTO>> getAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(franchiseService.findAll());
        return ResponseEntity.ok(franchises);
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<FranchiseDTO> getById(@PathVariable int id) {
        FranchiseDTO franchise = franchiseMapper.franchiseToFranchiseDto(franchiseService.findById(id));
        return ResponseEntity.ok(franchise);
    }

    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity add(@RequestBody FranchiseDTO franchiseDTO) {
        Franchise franchise = franchiseService.add(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchises/1
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if (id != franchiseDTO.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/franchises/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/movies") // GET: localhost:8080/api/v1/franchises/1/movies
    public ResponseEntity<Collection<MovieDTO>> getAllMovies(@PathVariable int id) {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(franchiseService.getMovies(id));
        return ResponseEntity.ok(movies);
    }

    @GetMapping("{id}/characters") // GET: localhost:8080/api/v1/franchises/1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters(@PathVariable int id) {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(franchiseService.getCharacters(id));
        return ResponseEntity.ok(characters);
    }

    @PutMapping("{id}/movies") // PUT: localhost:8080/api/v1/franchises/1/movies
    public ResponseEntity updateMovies(@RequestBody int[] characterIds, @PathVariable int movieId) {
        franchiseService.updateMovies(movieId, characterIds);
        return ResponseEntity.noContent().build();
    }
}
