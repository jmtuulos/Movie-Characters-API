package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO projectToProjectDto(Movie movie);
}
