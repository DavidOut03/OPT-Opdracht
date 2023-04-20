package main.java.kenmerken;

import main.java.kenmerken.Kenmerk;

import java.util.ArrayList;
import java.util.List;


public class KenmerkenLijst {

    private static List<Kenmerk> kenmerkList = new ArrayList<>();


    public static List<Kenmerk> getKenmerkList() {
        if(kenmerkList == null || kenmerkList.isEmpty()) {
            kenmerkList = new ArrayList<>();
//            kenmerkList.add(new Kenmerk("Example", 0.095));
        }

        return kenmerkList;
    }

    public static void addKenmerk(String kenmerkOmschrijving, double inkomensMultiplier) {
        if(kenmerkOmschrijving.isEmpty() || kenmerkOmschrijving == null) return;
        if(inkomensMultiplier == 0) return;

        kenmerkList.add(new Kenmerk(kenmerkOmschrijving, inkomensMultiplier));
    }

    public static void setUpDefaultKenmerkenLijst() {
        kenmerkList = new ArrayList<>();

        addKenmerk("Personneelslid meldt zich ziek en kan niet meer werken en  het komt niet door een dienstongeval of beroepsziekte", 0.7);
        addKenmerk("Personneelslid is 0 tot 6 maanden ziek.", 1);
        addKenmerk("Personneelslid is 6 tot 12 maanden ziek.", .9);
        addKenmerk("Personneelslid is 12 tot 18 maanden ziek.", .8);
        addKenmerk("Personneelslid is langer dan 2 jaar ziek.", .7);
    }
}
