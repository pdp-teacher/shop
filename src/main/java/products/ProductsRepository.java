package products;

import common.BaseRepository;
import order.OrderRepository;

import java.util.UUID;

public class ProductsRepository extends BaseRepository<Products, UUID> {
    @Override
    protected String getFilePath() {
        return PATH;
    }
    private static  final String PATH = "src/main/java/products/ProductsDataSource.txt";

    private static ProductsRepository productsRepository;

    private ProductsRepository(){

    }



    public static ProductsRepository getInstance(){
        if(productsRepository == null){
            productsRepository = new ProductsRepository();
        }
        return productsRepository;
    }
}
