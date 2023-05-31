package payment;

import common.BaseRepository;

import java.io.File;
import java.io.IOException;

public class PaymentRepository extends BaseRepository<Payment> {
    private final String FILE_PATH = "src/main/java/payment/payment.txt";

    @Override
    protected String getPath() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return FILE_PATH;
    }
}
