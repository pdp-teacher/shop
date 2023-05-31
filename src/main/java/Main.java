import user.User;
import user.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.save(new User("username","pass","fir","las","sksk"));

    }
}
