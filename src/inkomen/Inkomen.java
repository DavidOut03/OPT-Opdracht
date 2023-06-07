package inkomen;

import kenmerken.KenmerkenLijst;
import personen.Personeelslid;

public abstract class Inkomen {


    private double inkomen;
    public Inkomen(double inkomen) {
        this.inkomen = inkomen;
    }

    protected double getOrgineelIkomen() {return inkomen;}

    public String getFormatedInkomen() {
        return String.format("%.2f", getNieuwInkomen());
    }

    public abstract double getNieuwInkomen();
}
