package inkomen.type;

import inkomen.Inkomen;
import personen.Personeelslid;

public abstract class Uitkering extends Inkomen {

    private int percentage;

    public Uitkering(double inkomen, int percentage) {
        super(inkomen);
        this.percentage = percentage;
    }
    protected int getPercentage() {
        return percentage;
    }
}
