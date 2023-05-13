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

    public static boolean rechtOpWGA(boolean langerDan2JaarZiek, boolean nietOfMinderWerken, boolean nietOudeLoonVerdienen) {
        return (langerDan2JaarZiek && nietOfMinderWerken || langerDan2JaarZiek && nietOudeLoonVerdienen)? true : false;
    }

    public static double berekenInkomen(int aantalMaandenZiek) {
        if(aantalMaandenZiek < 6) return 100;
        if(aantalMaandenZiek >= 6 && aantalMaandenZiek <= 12) return 90;
        return 80;
    }


    public static String getNieuwUitkeringPlusInkomen(int aantalMaandenZiekte, boolean heeftEenUitkering, boolean genoegVerdienenToekomst, boolean kanMeerWerkenInToekomst) {
        String returned = "";
        if(heeftEenUitkering){
            returned = "WGA 70%";
            if(!genoegVerdienenToekomst) returned = "IVA 75%";
            return returned;
        }


            if(aantalMaandenZiekte > 0 && aantalMaandenZiekte < 12) {
                return "Geen 90%";
            } else if(aantalMaandenZiekte >= 12 && aantalMaandenZiekte < 24) {
                return "Geen 80%";
            }

            if(kanMeerWerkenInToekomst) return "WGA 70%";
            if(!genoegVerdienenToekomst) return "IVA 75%";

            return returned;
    }

}
