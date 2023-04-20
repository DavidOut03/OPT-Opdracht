
import org.junit.jupiter.api.Test;
import personen.Arbeidsdeskundige;

class ArbeidsdeskundigeTest {

    @Test
    void verstuurEmail() {
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("davidout94@gmail.com");
        arbeidsdeskundige.setVerstuurNaarArbeidsdeskundige(true);
        arbeidsdeskundige.verstuurEmail();
    }
}