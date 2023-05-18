package inkomen.uitkering;

public class IVAUitkering extends Uitkering {


    public IVAUitkering(double inkomen) {
        super(inkomen);
    }

    @Override
    protected double getNieuwInkomen() {
        return this.getPercentage() * getOrgineelInkomen();
    }

    @Override
    protected int getPercentage() {
        return 75;
    }
}
