package africa.semicolon.Unicoin.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender {
//    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String to, String email) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, "");
        mimeMessageHelper.setSubject("Confirm your email address");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom("pelumijsh@gmail.com");
        mimeMessageHelper.setText(email, true);
        javaMailSender.send(mailMessage);

    }
}
