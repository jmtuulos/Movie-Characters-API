package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Franchise entity) {

    }

    @Override
    public void updateMovies(int franchiseId, int[] movieId) {

    }

    @Override
    public Collection<Movie> getMovies(int franchiseId) {

        return List.of(new Movie[0]);
    }

    @Override
    public Collection<Character> getCharacters(int franchiseId) {

        return List.of(new Character[0]);
    }
}
