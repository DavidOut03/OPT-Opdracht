package inkomen;

public abstract  class Inkomen {

    private double inkomenHoeveelheid;

    public Inkomen(double inkomen) {
        this.inkomenHoeveelheid = inkomen;
    }

    public double getInkomen() {return inkomenHoeveelheid;}
}
