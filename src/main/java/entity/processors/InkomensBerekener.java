package entity.processors;


import entity.inkomen.NieuwInkomen;
import entity.kenmerken.Kenmerk;
import entity.personen.Arbeidsdeskundige;
import entity.personen.Personeelslid;

public class InkomensBerekener {

    private Personeelslid personeelslid;
    private Arbeidsdeskundige arbeidsdeskundige;
    private String berekening;

    public InkomensBerekener(Personeelslid personeelslid, Arbeidsdeskundige arbeidsdeskundige) {
        this.personeelslid = personeelslid;
        this.arbeidsdeskundige = arbeidsdeskundige;
    }

    public Personeelslid getPersoneelslid() {return personeelslid;}
    public Arbeidsdeskundige getArbeidsdeskundige() {return arbeidsdeskundige;}

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
