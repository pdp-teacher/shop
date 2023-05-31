package user;

import common.BaseRepository;

import java.io.File;
import java.io.IOException;

public class UserRepository extends BaseRepository<User> {
    private final String FILE_PATH = "src/main/java/user/user.txt";

    @Override
    protected String getPath() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return FILE_PATH;
    }
}
