package noroff.assignment.moviecharactersapi.services;

import noroff.assignment.moviecharactersapi.customexceptions.CharacterNotFoundException;
import noroff.assignment.moviecharactersapi.customexceptions.MovieNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import noroff.assignment.moviecharactersapi.models.Character;
import noroff.assignment.moviecharactersapi.repositories.CharacterRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<Character> chars = characterRepository.findAll();
        return chars;
    }

    @Override
    public Character add(Character character) {
        Character chara = characterRepository.save(character);
        return chara;
    }

    @Override
    public Character update(Character character) {
        Character chara = characterRepository.save(character);
        return chara;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
            Character chara = characterRepository.findById(id).get();
            //char.getMovies().forEach(s -> s.setCharacter(null));
            //todo: remove character from movies
            characterRepository.delete(chara);
        } else
            logger.warn("No character exists with ID: " + id);
    }

    @Override
    public List<Character> getCharacters(int movieId) {
        return characterRepository.findAllByMovies_Id(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    @Override
    public void delete(Character character) {
        characterRepository.delete(character);
    }
}
