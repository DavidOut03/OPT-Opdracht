package processors;

import inkomen.NieuwInkomen;
import kenmerken.Kenmerk;
import org.junit.Assert;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;

public class InkomensBerekener {

    private Personeelslid personeelslid;
    private Arbeidsdeskundige arbeidsdeskundige;

    public InkomensBerekener(Personeelslid personeelslid, Arbeidsdeskundige arbeidsdeskundige) {
        this.personeelslid = personeelslid;
        this.arbeidsdeskundige = arbeidsdeskundige;
    }

    public Personeelslid getPersoneelslid() {return personeelslid;}
    public Arbeidsdeskundige getArbeidsdeskundige() {return arbeidsdeskundige;}

    public double berekenInkomen()  {
        double inkomen = personeelslid.getOudinkomen().getInkomen();
        Assert.assertNotEquals(0, inkomen);

        String berekening = inkomen + "";

        for (Kenmerk kenmerk : personeelslid.getKenmerken()) {
            inkomen = inkomen * kenmerk.getInkomensMultiplier();
            berekening += " * " + kenmerk.getInkomensMultiplier();
        }

        personeelslid.setNieuwInkomen(new NieuwInkomen(inkomen, berekening));
        return inkomen;
    }

}
