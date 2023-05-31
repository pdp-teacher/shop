package payment;

import products.Products;
import products.ProductsService;
import user.User;
import user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PaymentService {
    private final PaymentRepository paymentRepository = PaymentRepository.getInstance();
    ProductsService productsService = new ProductsService();
    Products products = new Products();

    public Payment create(Payment payment){
        payment.setId(UUID.randomUUID());
        payment.setAmount(byAmount(products));
        payment.setCreated(LocalDateTime.now());
        payment.setUpdated(LocalDateTime.now());
        return paymentRepository.save(payment);
    }
    public void delete(UUID uuid){
        paymentRepository.deleteById(uuid);
    }
    public List<Payment> getAll(){
        return paymentRepository.getAll();
    }
    public Payment findById (UUID id){
        return paymentRepository.findById(id);
    }
    public Double byAmount(Products products){
        double amount=+productsService.calculationProductsPrice(products);
        return amount;
    }


}
