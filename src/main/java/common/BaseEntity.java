package common;

import java.time.LocalDateTime;
import java.util.UUID;

import  lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity <ID>{
    private LocalDateTime created;
    private LocalDateTime updated;
    protected UUID id;

}
