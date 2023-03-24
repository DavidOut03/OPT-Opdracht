package processors;

import personen.Persoon;

import java.util.ArrayList;
import java.util.List;

public class Emailer {

    private List<Persoon> personen;

    public Emailer() {
        this.personen = new ArrayList<>();
    }

    public List<Persoon> getPersonenOmTeMailer() {return personen;}

    public void stuurEmail() {

    }
}
