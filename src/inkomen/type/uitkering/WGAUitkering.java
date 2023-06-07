package inkomen.type.uitkering;

import inkomen.type.Uitkering;
import personen.Personeelslid;

public class WGAUitkering extends Uitkering {

    public WGAUitkering(double inkomen) {
        super(inkomen, 70);
    }

    @Override
    public double getNieuwInkomen() {
        return this.getOrgineelIkomen() * ((double) this.getPercentage() / 100);
    }
}
