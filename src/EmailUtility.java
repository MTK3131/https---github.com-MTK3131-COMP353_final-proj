import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {
    public static void sendEmail(String toAddress,
            String subject, String message)
            throws AddressException, MessagingException, IOException {
        Properties defaultProps = new Properties();
        defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
        defaultProps.setProperty("mail.smtp.port", "587");
        defaultProps.setProperty("mail.user", "comp353project1@gmail.com");
        defaultProps.setProperty("mail.password", "bgku nspq cvsx zcgd");
        defaultProps.setProperty("mail.smtp.starttls.enable", "true");
        defaultProps.setProperty("mail.smtp.auth", "true");

        final String userName = defaultProps.getProperty("mail.user");
        final String password = defaultProps.getProperty("mail.password");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(defaultProps, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);
    }
}
