package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.models.dtos.MovieDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO movieToMovieDto(Movie movie);
    Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);
    Movie movieDtoToMovie(MovieDTO movieDTO);
}
