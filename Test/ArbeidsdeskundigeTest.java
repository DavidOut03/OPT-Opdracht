
import main.java.personen.Arbeidsdeskundige;
import org.junit.jupiter.api.Test;

class ArbeidsdeskundigeTest {

    @Test
    void verstuurEmail() {
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("davidout94@gmail.com");
        arbeidsdeskundige.setVerstuurNaarArbeidsdeskundige(true);
        arbeidsdeskundige.verstuurEmail();
    }
}