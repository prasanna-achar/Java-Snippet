package com.example.NoteSpring.Auth.Service;


import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String body){
        try{
//            SimpleMailMessage mail = new SimpleMailMessage();
//            mail.setTo(to);
//            mail.setSubject(subject);
//            mail.setText(body);
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            javaMailSender.send(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
