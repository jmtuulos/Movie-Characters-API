package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.dtos.FranchiseDTO;
import noroff.assignment.moviecharactersapi.models.dtos.IdDTO;
import noroff.assignment.moviecharactersapi.services.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is used to map between Franchise and FranchiseDTO.
 * It uses the MapStruct library to generate the implementation.
 * @see <a href="https://mapstruct.org/">MapStruct</a>
 */

@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {
    @Autowired
    protected MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract FranchiseDTO franchiseToFranchiseDto(Franchise franchise);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract Collection<FranchiseDTO> franchiseToFranchiseDto(Collection<Franchise> franchises);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "idsToMovies")
    public abstract Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);

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
