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

    public static double berekenInkomen(int aantalMaandenZiek, boolean nietOfMinderWerken, boolean nietOudeLoonVerdienen) {
        double inkomen = 100;

        if(aantalMaandenZiek >= 6 && aantalMaandenZiek < 12) inkomen = 90;
        if(aantalMaandenZiek >= 12 && aantalMaandenZiek < 18) inkomen = 80;
        if(aantalMaandenZiek >= 24) inkomen = 70;

        if(!nietOfMinderWerken || !nietOudeLoonVerdienen) return inkomen;
        return 75;
    }

    public static double berekenInkomen(boolean minderDan2jaarZiek, boolean nietOfMinderWerken, boolean nietOudeLoonVerdienen) {
        if(minderDan2jaarZiek) return 80;
        if(nietOfMinderWerken && nietOudeLoonVerdienen) return 75;
        return 70;
    }

    public static double berekenInkomen(int aantalMaandenZiek) {
        if(aantalMaandenZiek < 6) return 100;
        if(aantalMaandenZiek >= 6 && aantalMaandenZiek <= 12) return 90;
        return 80;
    }

}
