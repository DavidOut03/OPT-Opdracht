package email.type;

import personen.Arbeidsdeskundige;

public class ArbeidsdeskundigeEmail implements Email {

    private final Arbeidsdeskundige arbeidsdeskundige;

    public ArbeidsdeskundigeEmail(Arbeidsdeskundige arbeidsdeskundige) {
        this.arbeidsdeskundige = arbeidsdeskundige;
    }

    @Override
    public String getEmailAdres() {
        return arbeidsdeskundige.getEmail();
    }

    @Override
    public String getMessage() {
        return null;
    }
}
