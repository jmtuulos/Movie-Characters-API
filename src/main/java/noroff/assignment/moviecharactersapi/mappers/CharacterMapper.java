package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.dtos.CharacterDTO;
import noroff.assignment.moviecharactersapi.models.dtos.IdDTO;
import noroff.assignment.moviecharactersapi.services.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    @Autowired
    protected MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO characterToCharacterDto(Character character);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "idsToMovies")
    public abstract Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named("moviesToIds")
    Set<IdDTO> mapMoviesToIds(Set<Movie> source) {
        if (source == null)
            return null;

        return source.stream()
                .map(s -> (new IdDTO(s.getId())))
                .collect(Collectors.toSet());
    }

    @Named("idsToMovies")
    Set<Movie> mapIdsToMovies(Set<IdDTO> id) {
        return id.stream()
                .map(i -> movieService.findById(i.getId()))
                .collect(Collectors.toSet());
    }
}
