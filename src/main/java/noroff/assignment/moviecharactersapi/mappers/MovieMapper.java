package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.dtos.IdDTO;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import noroff.assignment.moviecharactersapi.services.CharacterService;
import noroff.assignment.moviecharactersapi.services.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is used to map between Movie and MovieDTO.
 * It uses MapStruct to generate the implementation.
 * @see <a href="https://mapstruct.org/">MapStruct</a>
 */

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected FranchiseService franchiseService;

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDto(Movie movie);

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);

    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "idsToCharacters")
    public abstract Movie movieDtoToMovie(MovieDTO movieDTO);

    @Named("charactersToIds")
    Set<IdDTO> mapCharactersToIds(Set<Character> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> (new IdDTO(s.getId())))
                .collect(Collectors.toSet());
    }

    @Named("idsToCharacters")
    Set<Character> mapIdsToProjects(Set<IdDTO> id) {
        return id.stream()
                .map(i -> characterService.findById(i.getId()))
                .collect(Collectors.toSet());
    }

    @Named("franchiseIdToFranchise")
    Franchise mapIdToFranchise(int id) {
        return franchiseService.findById(id);
    }
}
