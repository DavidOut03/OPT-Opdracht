package personen;

import javax.mail.MessagingException;

public abstract class Persoon {

    private String email;
    public String getEmail() {return email;}

    public Persoon(String email) {
        this.email = email;
    }

}
