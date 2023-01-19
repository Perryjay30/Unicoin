package africa.semicolon.Unicoin.registration.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConfirmTokenRequest {
    @NotBlank
    private String token;
    private String emailAddress;
}
