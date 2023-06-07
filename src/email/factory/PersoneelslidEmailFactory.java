package email.factory;

import email.type.ArbeidsdeskundigeEmail;
import email.type.Email;
import email.type.PersoneelslidEmail;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import personen.Persoon;

public class PersoneelslidEmailFactory extends EmailFactory {
    @Override
    public Email createPersonalizedEmail(Persoon persoon) {
        if(!(persoon instanceof Personeelslid)) return null;
        Personeelslid personeelslid = (Personeelslid) persoon;
        return new PersoneelslidEmail(personeelslid);
    }

}
