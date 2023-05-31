package order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order
{
    private UUID orderId;
    private UUID userId;
    private UUID productId;
    private UUID paymentId;
    private LocalDateTime created;
    private LocalDateTime updated;
}
