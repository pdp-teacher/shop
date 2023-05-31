package payment;

import common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment extends BaseEntity<UUID> implements Serializable {
    private UUID paymentId;
    private User user;
    private Double amount;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Override
    protected UUID getAllID() {
        return paymentId;
    }
}
