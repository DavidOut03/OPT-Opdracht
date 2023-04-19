package test;

import kenmerken.KenmerkenLijst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KenmerkenLijstTest {

    @Test
    void addKenmerk() {
        KenmerkenLijst.addKenmerk("Langer dan 3 jaar ziek", 0.6);
        assertEquals(1, KenmerkenLijst.getKenmerkList().size());
    }
}