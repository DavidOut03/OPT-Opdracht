
import org.junit.jupiter.api.Test;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;

class ArbeidsdeskundigeTest {

    @Test
    void verstuurEmail() {
        Personeelslid janModaal = new Personeelslid("davidout94@gmail.com", 35000);
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("22056963@student.hhs.nl", janModaal);
        arbeidsdeskundige.setVerstuurNaarArbeidsdeskundige(true);
        arbeidsdeskundige.verstuurEmail();
    }
}