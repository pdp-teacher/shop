package user;

import order.Order;
import order.OrderRepository;
import payment.Payment;
import payment.PaymentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class UserService {

    private UserRepository userRepository = UserRepository.getInstance();
    private OrderRepository orderRepository = OrderRepository.getInstance();
    private PaymentRepository paymentRepository = PaymentRepository.getInstance();
    private static UserService userService;

    private UserService (){

    }


    public List<User> getMuchSpentUsers(){

        List<Payment> paymentID = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (Order order : orderRepository.readFromFile()) {
            paymentID.add(order.getPayment());
        }
        for (int i = 0; i < paymentID.size(); i++) {
            if (paymentID.get(i).getAmount() > 500_000){
                users.add(paymentID.get(i).getUser());
            }
        }
        return users;
    }


    public static UserService getInstance() {

        if (Objects.isNull(userService)){
            userService = new UserService();
        }

        return userService;
    }

}
