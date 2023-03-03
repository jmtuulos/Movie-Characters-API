package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.FranchiseNotFoundException;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.repositories.FranchiseRepository;
import noroff.assignment.moviecharactersapi.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> {
                            logger.warn("No franchise exists with ID: " + id);
                            return new FranchiseNotFoundException(id);
                        }
                );
    }

    @Override
    public List<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
            Franchise franchise = findById(id);
            franchise.getMovies().forEach(m -> m.setFranchise(null));
            franchiseRepository.delete(franchise);
    }

    @Override
    public void delete(Franchise franchise) {
        franchise.getMovies().forEach(m -> m.setFranchise(null));
        franchiseRepository.delete(franchise);
    }

    @Override
    public void updateMovies(int franchiseId, int[] movieId) {
        Franchise franchise = findById(franchiseId);
        List<Movie> movies = movieRepository.findAllById(Arrays.stream(movieId).boxed().collect(Collectors.toList()));
        for (Movie m : movies) {
            m.setFranchise(franchise);
        }
        franchiseRepository.save(franchise);
    }

    @Override
    public Set<Movie> getMovies(int franchiseId) {
        return findById(franchiseId).getMovies();
    }

    @Override
    public List<Character> getCharacters(int franchiseId) {
        return findById(franchiseId).getMovies().stream().flatMap(m -> m.getCharacters().stream()).distinct().toList();
    }
}
