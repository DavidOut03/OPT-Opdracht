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
    public void rechtOpWGA() {
        assertEquals(false, InkomensBerekener.rechtOpWGA(false, true, true));
        assertEquals(false, InkomensBerekener.rechtOpWGA(false, false, true));
        assertEquals(true, InkomensBerekener.rechtOpWGA(true, true, true));
        assertEquals(true, InkomensBerekener.rechtOpWGA(true, false, true));
        assertEquals(true, InkomensBerekener.rechtOpWGA(true, true, false));
        assertEquals(false, InkomensBerekener.rechtOpWGA(true, false, false));
        assertEquals(false, InkomensBerekener.rechtOpWGA(false, true, false));
        assertEquals(false, InkomensBerekener.rechtOpWGA(false, false, false));
    }

    @Test
    public void berekenMinderDan2JaarZiek() {
        assertEquals(100, InkomensBerekener.berekenInkomen(5));
        assertEquals(90, InkomensBerekener.berekenInkomen(6));
        assertEquals(90, InkomensBerekener.berekenInkomen(7));
        assertEquals(90, InkomensBerekener.berekenInkomen(11));
        assertEquals(90, InkomensBerekener.berekenInkomen(12));
        assertEquals(80, InkomensBerekener.berekenInkomen(13));

    }

    @Test
    public void inkomensPercentagePlusUitkering() {
        Object[][] testData = {
                {6, true,	true,	false, "WGA 70%"},
                {6, false,	false,	true, "Geen 90%"},
                {15,	true,	false,	true, "IVA 75%"},
                {15,	false,	true,	false, "Geen 80%"},


                {28,	true,	true,	false, "WGA 70%"},
                {28,	false,	false,	true, "WGA 70%"},
                {6,	true,	false,	true, "IVA 75%"},
                {28,	true,	false,	true, "IVA 75%"},


                {6,	true,	true,	false, "WGA 70%"},
                {6,	false,	false,	true, "Geen 90%"},
                {15,	true,	false,	true, "IVA 75%"},
        };


        for (Object[] data : testData) {
            String uitkomst = InkomensBerekener.getNieuwUitkeringPlusInkomen((int) data[0], (boolean) data[1], (boolean) data[2], (boolean) data[3]);
            assertEquals(data[4], uitkomst);
        }

    }


}