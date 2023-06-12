package order;

import common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order extends BaseEntity<UUID> {
    private UUID userId;
    private UUID productId;
    private UUID paymentId;
}
