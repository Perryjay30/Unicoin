package africa.semicolon.Unicoin.user;

import africa.semicolon.Unicoin.registration.token.ConfirmationToken;
import africa.semicolon.Unicoin.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Override
    public String createAccount(User user) {
        userRepository.save(user);
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken =
                new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10), user);
        confirmationTokenService.savedConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public void enableUser(String emailAddress) {
        userRepository.enable(emailAddress);
    }

}
