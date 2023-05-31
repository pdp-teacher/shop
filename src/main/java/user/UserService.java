package user;

import products.Products;
import products.ProductsRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserRepository userRepository = UserRepository.getInstance();


    public User signIn(String name, String password) {
            User user = userRepository.findUserByNamePassword(name,password);
            if (user != null) {
                return user;
            }

        return null;
    }

    public User signUp(User user) {
        User userTest = userRepository.findUserByNamePassword(user.getUsername(),user.getPassword());
        if (userTest != null) {
            return null;
        }
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setCreated(LocalDateTime.now());
        user1.setUpdated(LocalDateTime.now());
        user1.setUsername(user.getUsername());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        userRepository.save(user1);
        return user1;
    }
    public void delete(UUID uuid){
        userRepository.deleteById(uuid);
    }
    public List<User> getAll(){
        return userRepository.getAll();
    }
    public User findById (UUID id){
        return userRepository.findById(id);
    }
}
