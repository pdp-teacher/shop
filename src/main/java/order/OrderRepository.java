package order;

import common.BaseRepository;

import java.util.Objects;
import java.util.UUID;

public class OrderRepository extends BaseRepository<Order, UUID> {

    private static OrderRepository orderRepository;

    private String PATH = "src/main/java/order/OrderFile.txt";

    @Override
    protected String getFilePath() {
        return PATH;
    }


    private OrderRepository (){}

    public static OrderRepository getInstance() {
        if (Objects.isNull(orderRepository)){
            orderRepository = new OrderRepository();
        }
        return orderRepository;
    }

}
