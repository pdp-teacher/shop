package products;

import common.BaseRepository;
import common.Repository;
import payment.Payment;
import payment.PaymentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductsRepository extends BaseRepository<Products, UUID> implements Repository<Products, UUID>{
    private static final String PATH = "src/main/java/products/ProductsDataSource.txt";
    private static ProductsRepository productsRepository;
    private ProductsRepository(){}
    List<Products> products = new ArrayList<>();
    @Override
    protected List<Products> getList() {
        return products;
    }

    @Override
    protected String getFilePath() {
        return PATH;
    }

    @Override
    public Products save(Products product) {
        products.add(product);
        return product;
    }

    @Override
    public Products findById(UUID id) {
        for (Products product : products) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Products> getAll() {
        return super.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        for (Products product : products) {
            if (product.getId().equals(id)){
                products.remove(product);
            }
        }
    }

    public static ProductsRepository getInstance() {
        if (productsRepository == null){
            productsRepository = new ProductsRepository();
            readFromFile(productsRepository,PATH);
        }
        return productsRepository;
    }

}
