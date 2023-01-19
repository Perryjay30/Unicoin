package africa.semicolon.Unicoin.registration.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
}
