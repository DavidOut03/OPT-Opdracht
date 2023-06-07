package email.factory;

import email.type.ArbeidsdeskundigeEmail;
import email.type.Email;
import personen.Arbeidsdeskundige;
import personen.Persoon;

public class ArbeidsdeskundigeEmailFactory extends EmailFactory {
    @Override
    public Email createPersonalizedEmail(Persoon persoon) {
        if(!(persoon instanceof Arbeidsdeskundige)) return null;
        Arbeidsdeskundige arbeidsdeskundige = (Arbeidsdeskundige) persoon;
        return new ArbeidsdeskundigeEmail(arbeidsdeskundige);
    }
}
