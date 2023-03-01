package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO characterToCharacterDto(Character character);
    Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);
    Character characterDtoToCharacter(CharacterDTO characterDTO);
}
