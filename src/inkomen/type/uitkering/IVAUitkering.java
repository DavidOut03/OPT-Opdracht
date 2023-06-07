package inkomen.type.uitkering;

import inkomen.type.Uitkering;
import personen.Personeelslid;

public class IVAUitkering extends Uitkering {

    public IVAUitkering(double inkomen) {
        super(inkomen, 75);
    }

    @Override
    public double getNieuwInkomen() {
        return this.getOrgineelIkomen() * ((double) this.getPercentage() / 100);
    }

}
