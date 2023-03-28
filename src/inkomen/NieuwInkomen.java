package inkomen;

public class NieuwInkomen extends Inkomen{

    private String berekening;
    public NieuwInkomen(double inkomen, String berekening) {
        super(inkomen);
        this.berekening = berekening;
    }

    @Override
    public double getInkomen() {
        return Math.round((float) super.getInkomen());
    }

    public String getFormatedInkomen() {
        return String.format("%,d", Math.round((float) super.getInkomen())) + ",00";
    }

    public String getBerekening() {return berekening;}
}
