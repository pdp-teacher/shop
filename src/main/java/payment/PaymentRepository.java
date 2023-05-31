package payment;

import common.BaseRepository;

import java.util.Objects;
import java.util.UUID;

public class PaymentRepository extends BaseRepository<Payment, UUID> {

    private static PaymentRepository paymentRepository;

    private String PATH = "src/main/java/products/ProductFile.txt";

    private PaymentRepository(){}


    @Override
    protected String getFilePath() {
        return PATH;
    }

    public static PaymentRepository getInstance() {

        if (Objects.isNull(paymentRepository)){
            paymentRepository = new PaymentRepository();
        }

        return paymentRepository;
    }


}
