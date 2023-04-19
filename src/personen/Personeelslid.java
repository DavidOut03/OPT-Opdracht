package personen;

import inkomen.NieuwInkomen;
import inkomen.OudInkomen;
import kenmerken.Kenmerk;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Personeelslid extends Persoon {

    private OudInkomen oudinkomen;
    private NieuwInkomen nieuwInkomen;
    private List<Kenmerk> kenmerken;

    public Personeelslid(String email, double oudInkomen) {
        super(email);

        this.oudinkomen = new OudInkomen(oudInkomen);
        this.nieuwInkomen = null;
        this.kenmerken = new ArrayList<>();
    }

    @Override
    public void verstuurEmail() {
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

    public OudInkomen getOudinkomen() {return this.oudinkomen;}
    public NieuwInkomen getNieuwInkomen() {return this.nieuwInkomen;}
    public List<Kenmerk> getKenmerken() {return this.kenmerken;}

    public void addKenmerk(Kenmerk kenmerk) {this.kenmerken.add(kenmerk);}

    public void setOudinkomen(OudInkomen oudinkomen) {this.oudinkomen = oudinkomen;}
    public void setNieuwInkomen(NieuwInkomen nieuwInkomen) {this.nieuwInkomen = nieuwInkomen;}

    public void setKenmerken(List<Kenmerk> kenmerken) {this.kenmerken = kenmerken;}
}
