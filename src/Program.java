import inkomen.Inkomen;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import email.Emailer;
import inkomen.InkomensBerekener;
import utillity.QuestionUtillity;

import java.util.Scanner;

public class Program {

    private InkomensBerekener inkomensBerekener;
    private Emailer emailer;
    private Arbeidsdeskundige arbeidsdeskundige;
    private Personeelslid personeelslid;


    public Program(Personeelslid personeelslid) {
        this.personeelslid = personeelslid;
        this.inkomensBerekener = new InkomensBerekener();
        this.emailer = new Emailer();
    }


    public void start(Scanner scanner) {
        Inkomen inkomen = this.inkomensBerekener.berekenNieuwInkomen(personeelslid);
        this.personeelslid.setNieuwInkomen(inkomen);

        System.out.println("Het nieuwe inkomen is: " + inkomen.getFormatedInkomen());

        this.emailer.verstuurEmail(this.personeelslid);

        boolean emailNaarArbeidsdeskundige = QuestionUtillity.jaOfNee(scanner, "Moet er een email verstuurd worden naar de arbeidsdeskundige?");
        if(!emailNaarArbeidsdeskundige) return;
        String email = QuestionUtillity.askQuestion(scanner, "Wat is het email adres van de arbeidsdeskundige");

        this.arbeidsdeskundige = new Arbeidsdeskundige(email);
        this.arbeidsdeskundige.setPersoneelslid( this.personeelslid);

        this.emailer.verstuurEmail( this.arbeidsdeskundige);
    }


}
