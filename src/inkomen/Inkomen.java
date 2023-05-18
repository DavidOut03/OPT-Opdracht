package inkomen;

public abstract class Inkomen {

    private final double inkomen;
    public Inkomen(double inkomen) {
        this.inkomen = inkomen;
    }

    protected double getOrgineelInkomen() {return this.inkomen;}
    protected abstract double getNieuwInkomen();
}
