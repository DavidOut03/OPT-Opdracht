import kenmerken.Kenmerk;
import org.junit.Test;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import processors.InkomensBerekener;

import static org.junit.Assert.assertEquals;


class InkomensBerekenerTest {
    @Test
    void berekenInkomen() {
        Personeelslid janModaal = new Personeelslid("davidout94@gmail.com", 35000);
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("22056963@student.hhs.nl", janModaal);
        janModaal.addKenmerk(new Kenmerk("Langer dan 2 jaar ziek", 0.7));
        InkomensBerekener berekener = new InkomensBerekener(janModaal);


        assertEquals(24500, berekener.berekenInkomen());
    }

    @Test
    void getBerekening() {
        Personeelslid janModaal = new Personeelslid("davidout94@gmail.com", 35000);
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("22056963@student.hhs.nl", janModaal);
        janModaal.addKenmerk(new Kenmerk("Langer dan 2 jaar ziek", 0.7));
        InkomensBerekener berekener = new InkomensBerekener(janModaal);

        assertEquals("35000.0 * 0.7", berekener.getBerekening());
    }


}