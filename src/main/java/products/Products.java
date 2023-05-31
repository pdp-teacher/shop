package products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor@NoArgsConstructor@Data
public class Products
{
    private UUID productId;
    private String name;
    private Double price;
    private LocalDateTime created;
    private LocalDateTime updated;
}
