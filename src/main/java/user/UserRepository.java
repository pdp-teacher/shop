package user;

import common.BaseRepository;
import order.OrderRepositry;
import products.ProductRepository;

import java.util.UUID;

public class UserRepository extends BaseRepository<User, UUID> {
    private static UserRepository userRepository;

    private UserRepository() {};

    private static final String FILE_NAME_USER="src/main/java/user/UserDataCourse.txt";

    @Override
    protected String getFilePath() {
        return FILE_NAME_USER;
    }
    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }
}
