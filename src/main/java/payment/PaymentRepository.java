package payment;

import common.BaseRepository;
import order.OrderRepositry;

import java.util.UUID;

public class PaymentRepository extends BaseRepository<Payment, UUID> {
    private static PaymentRepository paymentRepositoryp;

    private PaymentRepository() {};

    private static final String FILE_NAME_PAYMENT="src/main/java/payment/PaymentDataCourse.txt";

    @Override
    protected String getFilePath() {
        return FILE_NAME_PAYMENT;
    }
    public static PaymentRepository getInstance() {
        if (paymentRepositoryp == null) {
            paymentRepositoryp = new PaymentRepository();
        }
        return paymentRepositoryp;
    }
}
