package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.CharacterNotFoundException;
import noroff.assignment.moviecharactersapi.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.repositories.CharacterRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character character) {
        return characterRepository.save(character);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
            delete(findById(id));
        } else
            logger.warn("No character exists with ID: " + id);
    }

    @Override
    public void delete(Character character) {
        Set<Movie> movies = character.getMovies();
        movies.forEach(mov ->
                mov.getCharacters()
                        .removeIf(r -> r.getId() == character.getId()));
        movies.clear();

        characterRepository.delete(character);
    }
}
