package products;

import common.BaseEntity;
import common.BaseRepository;

import java.util.Objects;
import java.util.UUID;

public class ProductRepository extends BaseRepository<Products, UUID> {


    private String PATH = "src/main/java/products/ProductFile.txt";

    private static ProductRepository productRepository;


    private ProductRepository (){

    }

    @Override
    protected String getFilePath() {
        return PATH;
    }

    public static ProductRepository getInstance() {

        if (Objects.isNull(productRepository)){
            productRepository = new ProductRepository();
        }

        return productRepository;
    }


}
