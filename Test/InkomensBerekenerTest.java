import kenmerken.Kenmerk;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import processors.InkomensBerekener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void berekenProcentueleInkomen() {
        assertEquals(75, InkomensBerekener.berekenInkomen(false, true, true));
        assertEquals(70, InkomensBerekener.berekenInkomen(false, false, true));
        assertEquals(80, InkomensBerekener.berekenInkomen(true, true, true));
        assertEquals(80, InkomensBerekener.berekenInkomen(true, false, true));
        assertEquals(80, InkomensBerekener.berekenInkomen(true, true, false));
        assertEquals(80, InkomensBerekener.berekenInkomen(true, false, false));
        assertEquals(70, InkomensBerekener.berekenInkomen(false, true, false));
        assertEquals(70, InkomensBerekener.berekenInkomen(false, false, false));
    }

    @Test
    public void berekenMinderDan2JaarZiek() {
        assertEquals(100, InkomensBerekener.berekenInkomen(5));
        assertEquals(90, InkomensBerekener.berekenInkomen(6));
        assertEquals(90, InkomensBerekener.berekenInkomen(11));
        assertEquals(90, InkomensBerekener.berekenInkomen(12));
        assertEquals(80, InkomensBerekener.berekenInkomen(13));

    }

    @Test
    public void inkomensPercentagePlusUitkering() {
        assertEquals("Geen 90%", InkomensBerekener.getNieuwUitkeringPlusInkomen(6, "geen", 100, 70));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(13, "wga", 70, 40));
        assertEquals("IVA 75%", InkomensBerekener.getNieuwUitkeringPlusInkomen(25, "iva", 70, 10));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(6, "wga", 80, 13));
        assertEquals("Geen 80%", InkomensBerekener.getNieuwUitkeringPlusInkomen(13, "geen", 70, 70));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(25, "wga", 90, 40));
        assertEquals("IVA 75%", InkomensBerekener.getNieuwUitkeringPlusInkomen(6, "iva", 70, 50));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(13, "wga", 90, 10));
        assertEquals("Geen 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(25, "geen", 80, 80));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(6, "wga", 70, 75));
        assertEquals("IVA 75%", InkomensBerekener.getNieuwUitkeringPlusInkomen(13, "iva", 90, 40));
        assertEquals("WGA 70%", InkomensBerekener.getNieuwUitkeringPlusInkomen(25, "wga", 70, 95));

    }


}