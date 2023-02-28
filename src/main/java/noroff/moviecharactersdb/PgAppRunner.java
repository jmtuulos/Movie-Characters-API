package noroff.moviecharactersdb;

import noroff.moviecharactersdb.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
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

