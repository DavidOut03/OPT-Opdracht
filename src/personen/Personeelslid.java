package personen;

import inkomen.NieuwInkomen;
import inkomen.OudInkomen;
import kenmerken.Kenmerk;

import java.util.ArrayList;
import java.util.List;

public class Personeelslid extends Persoon{

    private OudInkomen oudinkomen;
    private NieuwInkomen nieuwInkomen;
    private List<Kenmerk> kenmerken;

    public Personeelslid(String email, double oudInkomen) {
        super(email);

        this.oudinkomen = new OudInkomen(oudInkomen);
        this.nieuwInkomen = null;
        this.kenmerken = new ArrayList<>();
    }

    public OudInkomen getOudinkomen() {return this.oudinkomen;}
    public NieuwInkomen getNieuwInkomen() {return this.nieuwInkomen;}
    public List<Kenmerk> getKenmerken() {return this.kenmerken;}

    public void addKenmerk(Kenmerk kenmerk) {this.kenmerken.add(kenmerk);}

    public void setOudinkomen(OudInkomen oudinkomen) {this.oudinkomen = oudinkomen;}
    public void setNieuwInkomen(NieuwInkomen nieuwInkomen) {this.nieuwInkomen = nieuwInkomen;}

    public void setKenmerken(List<Kenmerk> kenmerken) {this.kenmerken = kenmerken;}
}
