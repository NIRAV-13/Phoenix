package _Ph.project.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Dharminsinh = new User(
                    "Dharminsinh",
                    "dharminsinh@gmail.com",
                    "d 107",
                    "South Park St.",
                    "Halifax"

            );
            User Thomas = new User(
                    "Thomas",
                    "thomas@gmail.com",
                    "T99",
                    "Harbour view",
                    "Halifax"

            );

            repository.saveAll(
                    List.of(Dharminsinh,Thomas)
            );
        };
    }

}
