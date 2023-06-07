package personen;

public class Arbeidsdeskundige extends Persoon {

    private boolean verstuurNaarArbeidsdeskundige;
    private Personeelslid personeelslid;

    public Arbeidsdeskundige(String email) {
        super(email);
    }

    public boolean emailNaarArbeidsdeskundige() {return this.verstuurNaarArbeidsdeskundige;}
    public void setVerstuurNaarArbeidsdeskundige(boolean verstuur) {this.verstuurNaarArbeidsdeskundige = verstuur;}

    public Personeelslid getPersoneelslid() {return personeelslid;}
    public void setPersoneelslid(Personeelslid personeelslid) {this.personeelslid = personeelslid;}
}
