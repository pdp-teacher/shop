import order.Order;
import order.OrderRepository;
import payment.Payment;
import payment.PaymentRepository;
import products.ProductRepository;
import products.Products;
import user.User;
import user.UserRepository;
import user.UserService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = UserRepository.getInstance();
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "Jalol", "5555", "Jaloliddin", "Ikramov", "Yunusobod", LocalDateTime.now(), LocalDateTime.now());
        ProductRepository productRepository = ProductRepository.getInstance();
        Products product = productRepository.save(new Products(UUID.randomUUID(), "SOK", 500000D, LocalDateTime.now(), LocalDateTime.now()));
        PaymentRepository paymentRepository = PaymentRepository.getInstance();
        Payment payment = paymentRepository.save(new Payment(UUID.randomUUID(), user, 500000D, LocalDateTime.now(), LocalDateTime.now()));
        OrderRepository orderRepository = OrderRepository.getInstance();
        Order order = orderRepository.save(new Order(UUID.randomUUID(), uuid, product.getProductId(), payment.getPaymentId(), payment, LocalDateTime.now(), LocalDateTime.now()));
        User save = userRepository.save(user);
        UserService userService = UserService.getInstance();
        System.out.println(userService.getMuchSpentUsers());


    }
}
