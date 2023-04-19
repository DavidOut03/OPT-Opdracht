package personen;

public class Arbeidsdeskundige extends Persoon{

    private boolean verstuurNaarArbeidsdeskundige;

    public Arbeidsdeskundige(String email) {
        super(email);
    }

    @Override
    public void verstuurEmail() {
        if(!verstuurNaarArbeidsdeskundige) return;
    }

    public boolean emailNaarArbeidsdeskundige() {return this.verstuurNaarArbeidsdeskundige;}
    public void setVerstuurNaarArbeidsdeskundige(boolean verstuur) {this.verstuurNaarArbeidsdeskundige = verstuur;}
}
