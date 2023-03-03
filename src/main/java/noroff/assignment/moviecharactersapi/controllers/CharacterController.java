package noroff.assignment.moviecharactersapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import noroff.assignment.moviecharactersapi.customexceptions.ApiErrorResponse;
import noroff.assignment.moviecharactersapi.mappers.CharacterMapper;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.services.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Get all characters")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    )
            }
    )
    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<CharacterDTO>> getAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(characterService.findAll());
        return ResponseEntity.ok(characters);
    }

    @Operation(summary = "Get a character by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Character not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<CharacterDTO> getById(@PathVariable int id) {
        CharacterDTO character = characterMapper.characterToCharacterDto(characterService.findById(id));
        return ResponseEntity.ok(character);
    }

    @Operation(summary = "Add a character")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Character added",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
                    @ApiResponse(responseCode = "409", description = "Character already exists")
            }
    )
    @PostMapping // POST: localhost:8080/api/v1/characters
    public ResponseEntity add(@RequestBody CharacterDTO characterDTO) {
        characterService.add(characterMapper.characterDtoToCharacter(characterDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a character")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Character updated",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
                    @ApiResponse(responseCode = "404",
                            description = "Character not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/characters/1
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if (id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(characterMapper.characterDtoToCharacter(characterDTO));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a character")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Character deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Character not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
            }
    )
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/characters/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
