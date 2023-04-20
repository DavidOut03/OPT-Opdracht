package main.java.processors;


import main.java.inkomen.NieuwInkomen;
import main.java.kenmerken.Kenmerk;
import main.java.personen.Arbeidsdeskundige;
import main.java.personen.Personeelslid;

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
