package kenmerken;

import java.util.ArrayList;
import java.util.List;

public class KenmerkenLijst {

    private List<Kenmerk> kenmerkList;

    public List<Kenmerk> getKenmerkList() {
        if(kenmerkList == null || kenmerkList.isEmpty()) {
            kenmerkList = new ArrayList<>();
//            kenmerkList.add(new Kenmerk("Example", 0.095));
        }

        return this.kenmerkList;
    }
}
