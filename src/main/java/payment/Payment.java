package payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment
{
    private UUID paymentId;
    private Double amount;
    private LocalDateTime created;
    private LocalDateTime updated;
}
