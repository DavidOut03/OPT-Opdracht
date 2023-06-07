
import email.Emailer;
import org.junit.jupiter.api.Test;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;

class EmailerTest {

    @Test
    void verstuurEmail() {
        Personeelslid janModaal = new Personeelslid("davidout94@gmail.com", 35000);
        janModaal.getKenmerkenLijst().setProcentVanOudeLoon(20);
        janModaal.getKenmerkenLijst().setKanInDeToekomstMeerWerken(false);
        janModaal.getKenmerkenLijst().setAantalMaandenZiek(24);

        Emailer emailer = new Emailer();
        emailer.verstuurEmail(janModaal);
    }
}