package user;

import order.Order;
import order.OrderRepository;
import payment.Payment;
import payment.PaymentRepository;

import java.util.List;

public class UserService {
    private OrderRepository orderRepository = new OrderRepository();
    private PaymentRepository paymentRepository = new PaymentRepository();
    private UserRepository userRepository = new UserRepository();

    public User muchMoney() {
        List<Order> all = orderRepository.getAll();
        Order resorder = null;
        double amount = 0;
        for (Order order : all) {
            Payment payment = paymentRepository.get(order.getPaymentId());
            if (payment.getAmount() > amount) {
                amount = payment.getAmount();
                resorder = order;
            }
        }
        return userRepository.get(resorder.getUserId());
    }
}
