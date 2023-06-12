package user;

import order.Order;
import order.OrderRepository;
import payment.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepository userRepository = UserRepository.getInstance();
    PaymentRepository paymentRepository = PaymentRepository.getInstance();
    OrderRepository orderRepository = OrderRepository.getInstance();

    List<User> richUsers = new ArrayList<>();
    public List<User> getRichUsers(){
        List<Order> orderRepositoryAll = orderRepository.getAll();
        for (Order order : orderRepositoryAll) {

        }
        return null;
    }

}
