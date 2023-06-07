package inkomen.type;

import inkomen.Inkomen;
import personen.Personeelslid;

public class Loondoorbetaling extends Inkomen {

    private int aantalMaanden;
    public Loondoorbetaling(double inkomen, int aantalMaanden) {
        super(inkomen);
        this.aantalMaanden = aantalMaanden;
    }

    @Override
    public double getNieuwInkomen() {
        if(aantalMaanden >= 0 && aantalMaanden < 6)  return getOrgineelIkomen();
        if(aantalMaanden >=6 && aantalMaanden< 12) return getOrgineelIkomen() * .9;
        if(aantalMaanden >=12 && aantalMaanden < 18)  return getOrgineelIkomen() * .8;
        return getOrgineelIkomen() * .7;
    }
}
