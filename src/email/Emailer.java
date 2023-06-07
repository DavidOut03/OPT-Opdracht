package email;

import email.factory.EmailFactory;
import email.type.Email;
import inkomen.Inkomen;
import org.junit.jupiter.api.parallel.Execution;
import personen.Arbeidsdeskundige;
import personen.Persoon;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Emailer {

    public void verstuurEmail(Persoon persoon) {
        if(persoon == null) return;
        Email email = EmailFactory.createEmail(persoon);

        String username = "davidoutdeveloper@gmail.com";
        String password = "rmsijixejwjvyevb";

        Session session = createSession(username, password);

        try {
            Message message = createMessage(username, email, session);
            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Session createSession(String username, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return  Session.getInstance(props, new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}});
    }

    private Message createMessage(String username, Email email, Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));

        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(
                        email.getMessage()
                )
        );

        message.setSubject("Nieuw Loon");
        message.setText(email.getMessage());
        return message;
    }
}
