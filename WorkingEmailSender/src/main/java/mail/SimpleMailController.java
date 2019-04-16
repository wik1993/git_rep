package mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@RestController
public class SimpleMailController {

    private JavaMailSender sender;

    @Autowired
    public SimpleMailController(JavaMailSender sender) {
        this.sender = sender;
    }

    @RequestMapping("/sendMail")
    public String sendMail() {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("gligor.viktor@gmail.com");
            helper.setFrom("Mister Incognito");
            helper.setText("Hello tipa");
            helper.setSubject("Mail From Spring Boot made by Gligor Victor");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }

        sender.send(message);
        return "Mail Sent Success!";
    }
}
