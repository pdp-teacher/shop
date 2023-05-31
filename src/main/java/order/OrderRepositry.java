package order;

import common.BaseRepository;
import payment.Payment;

import java.util.UUID;

public class OrderRepositry extends BaseRepository<Payment, UUID> {


private static OrderRepositry orderRepositry;

    private OrderRepositry() {};

    private static final String FILE_NAME="src/main/java/order/OrderDataCourse.txt";

    @Override
    protected String getFilePath() {
        return FILE_NAME;
    }
    public static OrderRepositry getInstance() {
        if (orderRepositry == null) {
            orderRepositry = new OrderRepositry();
        }
        return orderRepositry;
    }

}
