package africa.semicolon.Unicoin.exceptions;

import africa.semicolon.Unicoin.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class RegistrationException  extends Exception{

    public RegistrationException(String message) {
        super(message);
    }
}
