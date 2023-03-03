package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Character;

import java.util.List;

public interface CharacterService extends CrudService<Character, Integer> {
    List<Character> getCharacters(int movieId);
}
