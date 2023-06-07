

import inkomen.Inkomen;
import kenmerken.KenmerkenLijst;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import inkomen.InkomensBerekener;
import utillity.QuestionUtillity;

import javax.mail.MessagingException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

        public static void main(String[] args) throws MessagingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        String email = QuestionUtillity.askQuestion(scanner, "Wat is het e-mail adres van het personeelslid?");
        double oudInkomen = QuestionUtillity.inkomenVraag(scanner, "Wat is het huidige inkomen van het personeelslid?");
        int aantalMaanden = QuestionUtillity.nummerVraag(scanner, "Hoeveel maanden is het personeelslid al ziek?");
        boolean meerWerken = QuestionUtillity.jaOfNee(scanner,"Verwacht u dat het personeelslid in de toekomst weer meer zal kunnen werken.");
        int percentage = QuestionUtillity.nummerVraag(scanner, "Wat is het percentage dat het personeelslid nog kan verdienen wanneer hij of zij weer aan het werk gaat.");

        Personeelslid personeelslid = new Personeelslid(email, oudInkomen);
        personeelslid.getKenmerkenLijst().setAantalMaandenZiek(aantalMaanden);
        personeelslid.getKenmerkenLijst().setKanInDeToekomstMeerWerken(meerWerken);
        personeelslid.getKenmerkenLijst().setProcentVanOudeLoon(percentage);

        Program program = new Program(personeelslid);
        program.start(scanner);
    }







}