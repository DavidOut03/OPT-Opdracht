package processors;

import inkomen.NieuwInkomen;
import kenmerken.Kenmerk;
import org.junit.Assert;
import org.junit.Test;
import personen.Personeelslid;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GegevensReceiver {


    private Personeelslid personeelslid;

    public GegevensReceiver(Personeelslid personeelslid) {
        this.personeelslid = personeelslid;
    }

    @Test
    public void berekenInkomen()  {
        double inkomen = personeelslid.getOudinkomen().getInkomen();
        Assert.assertNotEquals(0, inkomen);

        String berekening = inkomen + "";

        for (Kenmerk kenmerk : personeelslid.getKenmerken()) {
            inkomen = inkomen * kenmerk.getInkomensMultiplier();
            berekening += " * " + kenmerk.getInkomensMultiplier();
        }

        Assert.assertNotEquals(0, inkomen);
        personeelslid.setNieuwInkomen(new NieuwInkomen(inkomen, berekening));

    }
}
