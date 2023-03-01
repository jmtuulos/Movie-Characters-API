package noroff.assignment.moviecharactersapi.controllers;

import noroff.assignment.moviecharactersapi.mappers.CharacterMapper;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.services.CharacterService;
import noroff.assignment.moviecharactersapi.models.Character;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(characterService.findAll());
        return ResponseEntity.ok(characters);
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<CharacterDTO> getById(@PathVariable int id) {
        CharacterDTO character = characterMapper.characterToCharacterDto(characterService.findById(id));
        return ResponseEntity.ok(character);
    }

    @PostMapping // POST: localhost:8080/api/v1/characters
    public ResponseEntity add(@RequestBody CharacterDTO characterDTO) {
        Character chara = characterService.add(characterMapper.characterDtoToCharacter(characterDTO));
        //URI location = URI.create("characters/" + chara.getId());
        //return ResponseEntity.created(location).build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        // Validates if body is correct
        if (id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(characterMapper.characterDtoToCharacter(characterDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
