package personen;

public abstract class Persoon {

    private String email;

    public Persoon(String email) {
        this.email = email;
    }

    public String getEmail() {return email;}

    public void verstuurEmail() {}
}
