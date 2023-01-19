package africa.semicolon.Unicoin.registration;

import africa.semicolon.Unicoin.registration.dtos.ConfirmTokenRequest;
import africa.semicolon.Unicoin.registration.dtos.RegistrationRequest;
import africa.semicolon.Unicoin.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest registrationRequest) throws MessagingException {
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(registrationService.register(registrationRequest))
                .timeStamp(ZonedDateTime.now())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

//        return registrationService.register(registrationRequest);
    }

    public ResponseEntity<?> confirmToken
            (@RequestBody ConfirmTokenRequest confirmTokenRequest, HttpServletRequest httpServletRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(registrationService.confirmToken(confirmTokenRequest))
                .timeStamp(ZonedDateTime.now())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
