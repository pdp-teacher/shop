package payment;

import common.BaseRepository;
import order.OrderRepository;

import java.util.UUID;

public class PaymentRepository extends BaseRepository <Payment, UUID>{
    @Override
    protected String getFilePath() {
        return PATH;
    }

    private static  final String PATH = "src/main/java/payment/PaymentDataSource.txt";

    private static PaymentRepository paymentRepository;

    private PaymentRepository(){

    }

    public static PaymentRepository getInstance(){
        if(paymentRepository == null){
            paymentRepository = new PaymentRepository();
        }
        return paymentRepository;
    }
}
