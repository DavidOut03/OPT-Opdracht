package personen;

import inkomen.Inkomen;
import kenmerken.KenmerkenLijst;

public class Personeelslid extends Persoon {

    private KenmerkenLijst kenmerkenLijst;
    private Inkomen nieuwInkomen;
    private double oudinkomen;


    public Personeelslid(String email, double oudInkomen) {
        super(email);

        this.oudinkomen = oudInkomen;
        this.kenmerkenLijst = new KenmerkenLijst();
    }

    public double getOudinkomen() {return this.oudinkomen;}

    public KenmerkenLijst getKenmerkenLijst() {return kenmerkenLijst;}

    public Inkomen getNieuwInkomen() {return nieuwInkomen;}
    public void setNieuwInkomen(Inkomen inkomen) {this.nieuwInkomen = inkomen;}
}
