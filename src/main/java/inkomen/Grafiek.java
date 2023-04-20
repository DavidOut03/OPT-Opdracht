package main.java.inkomen;

public class Grafiek {

    private OudInkomen oudInkomen;
    private NieuwInkomen nieuwInkomen;

    public Grafiek(OudInkomen oudInkomen, NieuwInkomen nieuwInkomen) {
        this.oudInkomen = oudInkomen;
        this.nieuwInkomen = nieuwInkomen;
    }

    public OudInkomen getOudinkomen() {return this.oudInkomen;}
    public NieuwInkomen getNieuwInkomen() {return this.nieuwInkomen;}

    public void setOudinkomen(OudInkomen oudinkomen) {this.oudInkomen = oudinkomen;}
    public void setNieuwInkomen(NieuwInkomen nieuwInkomen) {this.nieuwInkomen = nieuwInkomen;}
}
