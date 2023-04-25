package processors;

import inkomen.NieuwInkomen;
import kenmerken.Kenmerk;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;

public class InkomensBerekener {

    private Personeelslid personeelslid;
    private String berekening;

    public InkomensBerekener(Personeelslid personeelslid) {
        this.personeelslid = personeelslid;
    }

    public Personeelslid getPersoneelslid() {return personeelslid;}

    public String getBerekening() {
        String berekening = personeelslid.getOudinkomen().getInkomen() + "";

        for (Kenmerk kenmerk : personeelslid.getKenmerken()) {
            berekening += " * " + kenmerk.getInkomensMultiplier();
        }

        return berekening;
    }

    public double berekenInkomen()  {
        double inkomen = personeelslid.getOudinkomen().getInkomen();

        for (Kenmerk kenmerk : personeelslid.getKenmerken()) {
            inkomen = inkomen * kenmerk.getInkomensMultiplier();
        }

        personeelslid.setNieuwInkomen(new NieuwInkomen(inkomen, this.getBerekening()));
        return inkomen;
    }

}
