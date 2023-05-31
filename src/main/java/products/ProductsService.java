package products;

import order.Order;
import order.OrderRepository;
import payment.Payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductsService {
    private final ProductsRepository productsRepository = ProductsRepository.getInstance();

    public Products create(Products products){
        products.setId(UUID.randomUUID());
        products.setName(products.getName());
        products.setQuantity(products.getQuantity());
        products.setPrice(products.getPrice());
        products.setCreated(LocalDateTime.now());
        products.setUpdated(LocalDateTime.now());
        return productsRepository.save(products);
    }
    public void delete(UUID uuid){
        productsRepository.deleteById(uuid);
    }
    public List<Products> getAll(){
        return productsRepository.getAll();
    }
    public Products findById (UUID id){
        return productsRepository.findById(id);
    }
    public Double calculationProductsPrice (Products products ){
        return products.getQuantity()*products.getPrice();
    }
}
