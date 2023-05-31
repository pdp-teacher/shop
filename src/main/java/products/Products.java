package products;

import common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor@Data
public class Products  extends BaseEntity<UUID> implements Serializable
{
    private UUID productId;
    private String name;
    private Double price;
    private int quantity;

}
