import entity.kenmerken.KenmerkenLijst;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class KenmerkenLijstTest {

    @Test
    void addKenmerk() {
        KenmerkenLijst.addKenmerk("Langer dan 3 jaar ziek", 0.6);
        Assert.assertEquals(1, KenmerkenLijst.getKenmerkList().size());
    }
}