package personen;

import processors.InkomensBerekener;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Arbeidsdeskundige extends Persoon{

    private boolean verstuurNaarArbeidsdeskundige;
    private Personeelslid personeelslid;

    public Arbeidsdeskundige(String email, Personeelslid personeelslid) {
        super(email);
        this.personeelslid = personeelslid;
    }

    @Override
    public void verstuurEmail() {
        if(!verstuurNaarArbeidsdeskundige) return;
        if(personeelslid == null) return;

        if(personeelslid.getNieuwInkomen() == null) {
            InkomensBerekener berekener = new InkomensBerekener(personeelslid);
            berekener.berekenInkomen();
        }

        final String username = "davidoutdeveloper@gmail.com";
        final String password = "rmsijixejwjvyevb";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

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
            message.setSubject("Nieuw Loon");
            message.setText("Beste Arbeidsdeskundige,"
                    + "\n\n hierbij het nieuwe berekende loon is " + this.personeelslid.getNieuwInkomen().getFormatedInkomen()
                    + "\n\n De gebruikte berekening is: " + this.personeelslid.getNieuwInkomen().getBerekening());

            Transport.send(message);
            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean emailNaarArbeidsdeskundige() {return this.verstuurNaarArbeidsdeskundige;}
    public void setVerstuurNaarArbeidsdeskundige(boolean verstuur) {this.verstuurNaarArbeidsdeskundige = verstuur;}
}
