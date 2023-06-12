package order;

import common.BaseRepository;
import common.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository extends BaseRepository<Order,UUID> implements Repository<Order, UUID> {

    private static final String PATH = "src/main/java/order/OrderDataSource.txt";
    private static OrderRepository orderRepository;
    private OrderRepository(){}
    List<Order> orders = new ArrayList<>();
    @Override
    protected List<Order> getList() {
        return orders;
    }

    @Override
    protected String getFilePath() {
        return PATH;
    }

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order findById(UUID id) {
        for (Order order : orders) {
            if (order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return getList();
    }

    @Override
    public void deleteById(UUID id) {
        for (Order order : orders) {
            if (order.getId().equals(id)){
                orders.remove(order);
            }
        }
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null){
            orderRepository = new OrderRepository();
            readFromFile(orderRepository,PATH);
        }
        return orderRepository;
    }

}
