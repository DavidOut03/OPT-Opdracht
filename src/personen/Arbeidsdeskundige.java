package personen;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Arbeidsdeskundige extends Persoon{

    private boolean verstuurNaarArbeidsdeskundige;

    public Arbeidsdeskundige(String email) {
        super(email);
    }

    @Override
    public void verstuurEmail() {
        if(!verstuurNaarArbeidsdeskundige) return;
        final String username = "davidoutdeveloper@gmail.com";
        final String password = "DavidOut123";

        System.out.println("1");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        System.out.println("2");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.getEmail()));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean emailNaarArbeidsdeskundige() {return this.verstuurNaarArbeidsdeskundige;}
    public void setVerstuurNaarArbeidsdeskundige(boolean verstuur) {this.verstuurNaarArbeidsdeskundige = verstuur;}
}
