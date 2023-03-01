package noroff.assignment.moviecharactersapi.controllers;

import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.Character;
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

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<Franchise>> getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> getById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise franch = franchiseService.add(franchise);
        //URI location = URI.create("franchises/" + franch.getId());
        //return ResponseEntity.created(location).build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchises/1
    public ResponseEntity update(@RequestBody Franchise franchise, @PathVariable int id) {
        // Validates if body is correct
        if (id != franchise.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/franchises/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/movies") // GET: localhost:8080/api/v1/franchises/1/movies
    public ResponseEntity<Collection<Movie>> getAllMovies(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.getMovies(id));
    }

    @GetMapping("{id}/characters") // GET: localhost:8080/api/v1/franchises/1/characters
    public ResponseEntity<Collection<Character>> getAllCharacters(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.getCharacters(id));
    }

    //TODO: updatemovies
}
