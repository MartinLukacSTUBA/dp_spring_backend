package com.example.dp_spring_backend.email;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class EmailService {

    Session session;
    Transport transport;
    Properties props;

    @Value("${spring.smtp.port}")
    private Integer port;
    @Value("${spring.smtp.host}")
    private String host;
    @Value("${spring.smtp.username}")
    private String username;
    @Value("${spring.smtp.password}")
    private String password;

    @Value("${protocol_for_sending_emails}")
    private String PROTOCOL;

    public void setupEmailService() {
        props = this.getProperties();
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.host", host);

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.enable", "false");

        properties.put("mail.protocol", "smtp");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        return properties;
    }


    public void sendEmailToEmployee(String subject, String message, String email) {
        this.setupEmailService();
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, email);
            msg.setSubject(subject);
            msg.setText(message);


            Transport tr = session.getTransport(PROTOCOL);
            tr.connect(host, username, password);
            msg.saveChanges();
            tr.sendMessage(msg, msg.getAllRecipients());

            tr.close();

        } catch (MessagingException e) {
            log.warn("MessagingException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}