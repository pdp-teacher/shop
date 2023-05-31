package user;

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
public class User extends BaseEntity<UUID> implements Serializable {
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime created;
    private LocalDateTime updated;


    @Override
    protected  UUID getAllID() {
        return userId;
    }
}
