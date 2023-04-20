package entity.inkomen;

public abstract class Inkomen {

    private double inkomenHoeveelheid;

    public Inkomen(double inkomen) {
        this.inkomenHoeveelheid = inkomen;
    }

    public double getInkomen() {return inkomenHoeveelheid;}

    public String getFormatedInkomen() {
        return String.format("%,d", Math.round((float) getInkomen())) + ",00";
    }
}
