package inkomen;

public class NieuwInkomen extends Inkomen{

    private String berekening;
    public NieuwInkomen(double inkomen, String berekening) {
        super(inkomen);
        this.berekening = berekening;
    }

    @Override
    public double getInkomen() {
        return Double.parseDouble(berekening);
    }

    public String getBerekening() {return berekening;}
}
