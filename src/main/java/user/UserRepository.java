package user;

import common.BaseRepository;
import products.ProductsRepository;

import java.util.UUID;

public class UserRepository extends BaseRepository<User, UUID> {
    @Override
    protected String getFilePath() {
        return PATH;
    }
    private static  final String PATH = "src/main/java/user/UserDataSource.txt";

    private static UserRepository userRepository;

    private UserRepository(){

    }



    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    public User findUserByNamePassword(String name,String password) {
        for (User user : readFromFile()) {
            if (user.getUsername().equals(name)&&user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
