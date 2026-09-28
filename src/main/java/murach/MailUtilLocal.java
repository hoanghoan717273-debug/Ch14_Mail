package murach;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtilLocal {

    public static void sendMail(
            String to,
            String from,
            String subject,
            String body,
            boolean bodyIsHTML)
            throws MessagingException {


        // Gmail dùng để gửi email
        final String username =
                "hoanghoan717273@gmail.com";

        // App Password của Gmail
        final String password =
                "gyup ffup ghds tpyk";


        // 1. Tạo Properties

        Properties props =
                new Properties();

        props.put(
                "mail.transport.protocol",
                "smtp"
        );

        props.put(
                "mail.smtp.host",
                "smtp.gmail.com"
        );

        props.put(
                "mail.smtp.port",
                "587"
        );

        props.put(
                "mail.smtp.auth",
                "true"
        );

        props.put(
                "mail.smtp.starttls.enable",
                "true"
        );


        // 2. Tạo Session

        Session session =
                Session.getInstance(
                        props,
                        new javax.mail.Authenticator() {

                            @Override
                            protected PasswordAuthentication
                            getPasswordAuthentication() {

                                return new PasswordAuthentication(
                                        username,
                                        password
                                );
                            }
                        }
                );


        session.setDebug(true);


        // 3. Tạo Message

        Message message =
                new MimeMessage(session);


        // 4. Subject

        message.setSubject(subject);


        // 5. Body

        if (bodyIsHTML) {

            message.setContent(
                    body,
                    "text/html"
            );

        } else {

            message.setText(body);
        }


        // 6. Người gửi

        Address fromAddress =
                new InternetAddress(username);


        // 7. Người nhận

        Address toAddress =
                new InternetAddress(to);


        // 8. Gán người gửi

        message.setFrom(fromAddress);


        // 9. Gán người nhận

        message.setRecipient(
                Message.RecipientType.TO,
                toAddress
        );


        // 10. Gửi email

        Transport.send(message);
    }
}