package user;

import common.BaseRepository;
import common.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository extends BaseRepository<User, UUID> implements Repository<User,UUID> {
    private static final String PATH = "src/main/java/user/UserDataSource.txt";
    private static UserRepository userRepository;
    private UserRepository(){}
    List<User> users = new ArrayList<>();
    @Override
    protected List<User> getList() {
        return users;
    }

    @Override
    protected String getFilePath() {
        return PATH;
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return getList();
    }

    @Override
    public void deleteById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                users.remove(user);
            }
        }
    }

    public static UserRepository getInstance() {
        if (userRepository == null){
            userRepository = new UserRepository();
            readFromFile(userRepository,PATH);
        }
        return userRepository;
    }
}
