package order;

import common.BaseRepository;

import java.util.UUID;

public class OrderRepository extends BaseRepository<Order, UUID> {
    @Override
    protected String getFilePath() {
        return PATH;
    }
    private static  final String PATH = "src/main/java/order/OrderDataSource.txt";

    private static OrderRepository orderRepository;

    private OrderRepository(){

    }



    public static OrderRepository getInstance(){
        if(orderRepository == null){
            orderRepository = new OrderRepository();
        }
        return orderRepository;
    }
}
