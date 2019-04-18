package internship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private JavaMailSender sender;

    @Autowired
    public MailService(JavaMailSender sender){
        this.sender = sender;
    }

    public void reportMarksToResponsible(){
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("gligor.viktor@gmail.com");
            helper.setText("Test");
            helper.setSubject("Mail From Spring Boot made by Gligor Victor");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        sender.send(message);
    }
}
