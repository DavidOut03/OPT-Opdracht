package inkomen;

public class NieuwInkomen extends Inkomen{

    private String berekening;
    public NieuwInkomen(double inkomen, String berekening) {
        super(inkomen);
        this.berekening = berekening;
    }

    public String getBerekening() {return berekening;}
}
