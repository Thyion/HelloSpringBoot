package pl.springBoot.HelloSpringBoot.Services;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.springBoot.HelloSpringBoot.interfaces.EmailSender;


@Service("emailSender")
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(to);
            helper.setFrom("noreply@app.net");
            helper.setSubject(subject);
            helper.setText(content, true);
        }catch (MessagingException ex){
            ex.printStackTrace();
        }
        javaMailSender.send(mail);
    }
}
