package order;

import common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order extends BaseEntity<UUID> implements Serializable {
    private UUID orderId;
    private UUID userId;
    private UUID productId;
    private UUID paymentId;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Override
    protected UUID getAllID() {
        return orderId;
    }
}
