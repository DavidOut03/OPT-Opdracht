package personen;

public class Arbeidsdeskundige extends Persoon {

    private Personeelslid personeelslid;

    public Arbeidsdeskundige(String email) {
        super(email);
    }


    public Personeelslid getPersoneelslid() {return personeelslid;}
    public void setPersoneelslid(Personeelslid personeelslid) {this.personeelslid = personeelslid;}
}
