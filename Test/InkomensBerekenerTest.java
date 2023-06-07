import inkomen.Inkomen;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import inkomen.InkomensBerekener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InkomensBerekenerTest {

    @Test
    void berekenInkomen() {
        Personeelslid janModaal = new Personeelslid("davidout94@gmail.com", 35000);
        janModaal.getKenmerkenLijst().setProcentVanOudeLoon(20);
        janModaal.getKenmerkenLijst().setKanInDeToekomstMeerWerken(false);
        janModaal.getKenmerkenLijst().setAantalMaandenZiek(24);

        InkomensBerekener inkomensBerekener = new InkomensBerekener();
        Inkomen inkomen = inkomensBerekener.berekenNieuwInkomen(janModaal);

        assertEquals(26250, inkomen.getNieuwInkomen());
    }

}