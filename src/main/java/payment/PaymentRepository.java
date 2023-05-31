package payment;

import common.BaseRepository;
import common.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentRepository extends BaseRepository<Payment, UUID> implements Repository<Payment, UUID> {

    private static final String PATH = "src/main/java/payment/PaymentDataSource.txt";
    private static PaymentRepository paymentRepository;
    private PaymentRepository(){}
    List<Payment> payments = new ArrayList<>();
    @Override
    protected List<Payment> getList() {
        return payments;
    }

    @Override
    protected String getFilePath() {
        return PATH;
    }

    @Override
    public Payment save(Payment payment) {
        payments.add(payment);
        return payment;
    }

    @Override
    public Payment findById(UUID id) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)){
                return payment;
            }
        }
        return null;
    }

    @Override
    public List<Payment> getAll() {
        return getList();
    }

    @Override
    public void deleteById(UUID id) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)){
                payments.remove(payment);
            }
        }
    }

    public static PaymentRepository getInstance() {
        if (paymentRepository == null){
            paymentRepository = new PaymentRepository();
            readFromFile(paymentRepository,PATH);
        }
        return paymentRepository;
    }

}


