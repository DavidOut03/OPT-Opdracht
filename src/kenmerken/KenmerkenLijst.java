package kenmerken;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KenmerkenLijst {

    private List<Kenmerk> kenmerkList;


    public List<Kenmerk> getKenmerkList() {
        if(kenmerkList == null || kenmerkList.isEmpty()) {
            kenmerkList = new ArrayList<>();
//            kenmerkList.add(new Kenmerk("Example", 0.095));
        }

        return this.kenmerkList;
    }

    @Test
    public void setUpDefaultKenmerkenLijst() {
        kenmerkList = new ArrayList<>();
        kenmerkList.add(new Kenmerk("Personneelslid meldt zich ziek en kan niet meer werken en  het komt niet door een dienstongeval of beroepsziekte", 0.7));
        kenmerkList.add(new Kenmerk("Personneelslid is 0 tot 6 maanden ziek.", 1));
        kenmerkList.add(new Kenmerk("Personneelslid is 6 tot 12 maanden ziek.", .9));
        kenmerkList.add(new Kenmerk("Personneelslid is 12 tot 18 maanden ziek.", .8));
        kenmerkList.add(new Kenmerk("Personneelslid is langer dan 2 jaar ziek.", .7));

        assertEquals(5, kenmerkList.size());
    }
}
