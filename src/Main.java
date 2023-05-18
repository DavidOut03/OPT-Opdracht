

import inkomen.emailer.Emailer;
import inkomen.emailer.factory.ArbeidsDeskundigeEmailerFactory;
import inkomen.emailer.factory.EmailerFactory;

import javax.mail.MessagingException;
import java.util.Scanner;

public class Main {

        public static void main(String[] args)  {
                EmailerFactory factory;
                Emailer emailer;

                factory = new ArbeidsDeskundigeEmailerFactory();
                emailer = factory.createEmailer();
                emailer.verstuurInkomen();
        }




}