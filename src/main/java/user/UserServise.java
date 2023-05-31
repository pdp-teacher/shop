package user;

import payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class UserServise {
    public static void main(String[] args) {

        UserRepository userRepository = UserRepository.getInstance();



        Payment payment = new Payment(UUID.randomUUID(), 12.321);
        User user = new User(UUID.randomUUID(), "sjdhv", "daf", "wdq", "df", "efs");


    }




   List<Payment> payments = new ArrayList<>();
    List<User> users = new ArrayList<>();

    HashMap<User,Payment> hashMaps=new HashMap<>();
    public User User_Spent_Alotof_Money_Metod(User user,Payment payment) {


//        for (HashMap<User,Payment> hashMap:hashMaps)
//            if (hashMap.getId().equals(user.getId())) {
//                System.out.println("user tolovi");
//            }

        for (User user1: users) {
            if(user1.getUserId().equals(payment.getId())){
                System.out.println("userni tolovi");
            }

        }

        return null;


    }

}
