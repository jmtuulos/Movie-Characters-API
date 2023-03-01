package noroff.assignment.moviecharactersapi;

import noroff.assignment.moviecharactersapi.repositories.CharacterRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PgAppRunner implements ApplicationRunner {

    private final CharacterRepository characterRepository;
    public PgAppRunner(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

