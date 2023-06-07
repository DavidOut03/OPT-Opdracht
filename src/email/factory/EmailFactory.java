package email.factory;

import email.type.Email;
import personen.Arbeidsdeskundige;
import personen.Persoon;

public abstract class EmailFactory {

    private static final EmailFactory PersoneelsEmailFactory = new PersoneelslidEmailFactory();
    private static final EmailFactory ArbeidsdeskundigeEmailFactory = new ArbeidsdeskundigeEmailFactory();


    public static Email createEmail(Persoon persoon) {
        return (persoon instanceof Arbeidsdeskundige) ? ArbeidsdeskundigeEmailFactory.createPersonalizedEmail(persoon) : PersoneelsEmailFactory.createPersonalizedEmail(persoon);
    }


    public abstract Email createPersonalizedEmail(Persoon persoon);
}
