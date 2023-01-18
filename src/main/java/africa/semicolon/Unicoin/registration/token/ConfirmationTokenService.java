package africa.semicolon.Unicoin.registration.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public void savedConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }

    public void getConfirmationToken(String token) {
        confirmationTokenRepository.findByToken(token);
    }

    public void deleteExpiredToken() {
        confirmationTokenRepository.deleteConfirmationTokenByExpiredAtBefore(LocalDateTime.now());
    }
}
