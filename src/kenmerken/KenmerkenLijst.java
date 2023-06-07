package kenmerken;

import java.util.ArrayList;
import java.util.List;


public class KenmerkenLijst {

    private int aantalMaandenZiek;
    private boolean meerWerken;
    private int procentNieuweLoon;

    public void setAantalMaandenZiek(int maandenZiek) {this.aantalMaandenZiek = maandenZiek;}
    public void setKanInDeToekomstMeerWerken(boolean werken) {this.meerWerken = werken;}
    public void setProcentVanOudeLoon(int procent) {this.procentNieuweLoon = procent;}

    public int getAantalMaandenZiek() {return aantalMaandenZiek;}
    public boolean kanMeerWerkenInDeToekomst() {return meerWerken;}
    public int getProcentVanOudeLoon() {return procentNieuweLoon;}
}
