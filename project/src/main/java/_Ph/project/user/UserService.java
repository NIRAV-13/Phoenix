package _Ph.project.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {

        Optional<User> userOptional = userRepository
                .findUserbyEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Someone else has used this email");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {

        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(userId+" does not exist");
        }
        userRepository.deleteById(userId);
    }
}
