package com.banthatlung.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String SMTP_USERNAME = "dungbui19304@gmail.com"; // Thay bằng email của bạn
    private static final String SMTP_PASSWORD = "uosy oyea kqjt cgjo"; // Thay bằng mật khẩu ứng dụng của bạn

    public void sendMail(String recipientEmail, String subject, String body) throws MessagingException {
        // Cấu hình các thuộc tính SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("javax.net.ssl.SSLContext", "TLSv1.2");

        // Tạo phiên làm việc với Gmail SMTP
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        });

        // Tạo email
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SMTP_USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }


}

