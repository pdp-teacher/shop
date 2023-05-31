package order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public Order create(Order order){
        order.setId(UUID.randomUUID());
        order.setCreated(LocalDateTime.now());
        order.setUpdated(LocalDateTime.now());
        return orderRepository.save(order);
    }
    public void delete(UUID uuid){
        orderRepository.deleteById(uuid);
    }
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
    public Order findById (UUID id){
        return orderRepository.findById(id);
    }
}
