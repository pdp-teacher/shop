import user.User;
import user.UserService;

import java.util.List;
import java.util.UUID;

public class Main
{
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.signUp(new User(UUID.randomUUID(),"ali@","333","Aliyev","Vali","Tafakkur 20"));
        //List<User> list = userService.getAll();
        //System.out.println(list);


    }


}
