
import entity.kenmerken.Kenmerk;
import entity.personen.Arbeidsdeskundige;
import entity.personen.Personeelslid;
import entity.processors.InkomensBerekener;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


class InkomensBerekenerTest {
    @Test
    void berekenInkomen() {
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("arbeidsdeskundige@politie.nl");
        Personeelslid janModaal = new Personeelslid("jan.modaal@gmail.com", 35000);
        janModaal.addKenmerk(new Kenmerk("Langer dan 2 jaar ziek", 0.7));
        InkomensBerekener berekener = new InkomensBerekener(janModaal, arbeidsdeskundige);


        assertEquals(24500, berekener.berekenInkomen());
    }

    @Test
    void getBerekening() {
        Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige("arbeidsdeskundige@politie.nl");
        Personeelslid janModaal = new Personeelslid("jan.modaal@gmail.com", 35000);
        InkomensBerekener berekener = new InkomensBerekener(janModaal, arbeidsdeskundige);
        janModaal.addKenmerk(new Kenmerk("Langer dan 2 jaar ziek", 0.7));

        assertEquals("35000.0 * 0.7", berekener.getBerekening());
    }


}