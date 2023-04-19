package test;

import org.junit.jupiter.api.Test;
import personen.Arbeidsdeskundige;

import static org.junit.jupiter.api.Assertions.*;

class ArbeidsdeskundigeTest {

    @Test
    void verstuurEmail() {
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("davidout94@gmail.com");
        arbeidsdeskundige.setVerstuurNaarArbeidsdeskundige(true);
        arbeidsdeskundige.verstuurEmail();
    }
}