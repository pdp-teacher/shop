package products;

import common.BaseRepository;
import order.OrderRepositry;
import payment.PaymentRepository;

import java.util.UUID;

public class ProductRepository extends BaseRepository<Products,UUID> {
    private static ProductRepository productRepository;

    private ProductRepository() {};

    private static final String FILE_NAME_PRODUCT="src/main/java/products/ProductDataCourse.txt";

    @Override
    protected String getFilePath() {
        return FILE_NAME_PRODUCT;
    }
    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }


}
