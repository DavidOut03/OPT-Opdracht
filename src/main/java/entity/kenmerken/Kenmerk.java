package entity.kenmerken;

public class Kenmerk {

    private String naam;
    private double inkomensMultiplier;

    public Kenmerk(String naam, double inkomensMultiplier) {
        this.naam = naam;
        this.inkomensMultiplier = inkomensMultiplier;
    }

    public String getNaam() {
        return this.naam;
    }

    public double getInkomensMultiplier() {
        return this.inkomensMultiplier;
    }
}
