import user.User;
import user.UserRepository;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository=UserRepository.getInstance();
        userRepository.save(new User(UUID.randomUUID(),"userneme","1221",
                "firstname","lastname","Buxara"));

    }
}
