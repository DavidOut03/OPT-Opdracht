package inkomen.emailer.factory;

import inkomen.emailer.ArbeidsdeskundigeEmailer;
import inkomen.emailer.Emailer;

public class ArbeidsDeskundigeEmailerFactory implements EmailerFactory {
    @Override
    public Emailer createEmailer() {
        return new ArbeidsdeskundigeEmailer();
    }
}
