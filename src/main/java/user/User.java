package user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User
{
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime created;
    private LocalDateTime updated;
}
