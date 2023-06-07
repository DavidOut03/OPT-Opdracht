package email.type;

import personen.Arbeidsdeskundige;
import personen.Personeelslid;

public class PersoneelslidEmail implements Email {
    private final Personeelslid personeelslid;

    public PersoneelslidEmail(Personeelslid personeelslid) {
        this.personeelslid = personeelslid;
    }

    @Override
    public String getEmailAdres() {
        return personeelslid.getEmail();
    }

    @Override
    public String getMessage() {
        return null;
    }
}
