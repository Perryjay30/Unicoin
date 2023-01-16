package africa.semicolon.Unicoin.registration;

import africa.semicolon.Unicoin.user.User;
import africa.semicolon.Unicoin.user.UserRepository;
import africa.semicolon.Unicoin.user.UserRole;
import africa.semicolon.Unicoin.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    public String register(RegistrationRequest registrationRequest) {
        boolean emailExists = userRepository.findByEmailAddressIgnoreCase
                (registrationRequest.getEmailAddress()).isPresent();
        if(emailExists)
            throw new IllegalStateException("Email Address already exists");
        return userService.createAccount(new User(
                        registrationRequest.getEmailAddress(),
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getPassword(),
                        UserRole.USER
                )
        );
    }
}
