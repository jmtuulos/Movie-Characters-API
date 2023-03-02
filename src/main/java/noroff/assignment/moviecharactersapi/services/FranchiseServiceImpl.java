package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.FranchiseNotFoundException;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.Movie;
import noroff.assignment.moviecharactersapi.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public List<Franchise> findAll() {
        List<Franchise> franchises = franchiseRepository.findAll();
        return franchises;
    }

    @Override
    public Franchise add(Franchise entity) {
        Franchise franchise = franchiseRepository.save(entity);
        return franchise;
    }

    @Override
    public Franchise update(Franchise entity) {
        Franchise franchise = franchiseRepository.save(entity);
        return franchise;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (franchiseRepository.existsById(id)) {
            Franchise franchise = franchiseRepository.findById(id).get();
            franchise.getMovies().forEach(m -> m.setFranchise(null));
            franchiseRepository.delete(franchise);
        } else
            logger.warn("No franchise exists with ID: " + id);
    }

    @Override
    public void delete(Franchise franchise) {
        franchise.getMovies().forEach(m -> m.setFranchise(null));
        franchiseRepository.delete(franchise);
    }

    @Override
    public void updateMovies(int franchiseId, int[] movieId) {
        //todo
    }

    @Override
    public Collection<Movie> getMovies(int franchiseId) {
        return findById(franchiseId).getMovies();
    }

    @Override
    public Collection<Character> getCharacters(int franchiseId) {
        //todo
        return List.of(new Character[0]);
    }
}
