package user;

import common.BaseEntity;
import common.BaseRepository;

import java.util.UUID;

public class UserRepository extends BaseRepository<User, UUID> {

   private static  UserRepository userRepository;

    private UserRepository (){}



    private String PATH = "src/main/java/user/UserFile.txt";

    @Override
    protected String getFilePath() {
        return PATH;
    }

    public static UserRepository getInstance() {

        if (userRepository == null){
            userRepository = new UserRepository();
            return userRepository;
        }

        return userRepository;
    }

}
