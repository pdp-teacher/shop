package order;

import common.BaseRepository;

public class OrderRepository extends BaseRepository<Order> {
    private final String FILE_PATH="src/main/java/order/order.txt";
    @Override
    protected String getPath() {
        return null;
    }
}
