package inkomen;


import inkomen.Inkomen;
import inkomen.type.Loondoorbetaling;
import inkomen.type.uitkering.IVAUitkering;
import inkomen.type.uitkering.WGAUitkering;
import personen.Personeelslid;
import personen.Persoon;

public class InkomensBerekener {

    public Inkomen berekenNieuwInkomen(Personeelslid personeelslid) {
        int aantalMaanden = personeelslid.getKenmerkenLijst().getAantalMaandenZiek();
        boolean kanMeerWerken = personeelslid.getKenmerkenLijst().kanMeerWerkenInDeToekomst();
        int procentOudeInkomen = personeelslid.getKenmerkenLijst().getProcentVanOudeLoon();

        if(aantalMaanden >= 0 && aantalMaanden < 6) return new Loondoorbetaling(personeelslid.getOudinkomen(), aantalMaanden);
        if(aantalMaanden >=6 && aantalMaanden< 12) return new Loondoorbetaling(personeelslid.getOudinkomen(), aantalMaanden);
        if(aantalMaanden >=12 && aantalMaanden < 18) return new Loondoorbetaling(personeelslid.getOudinkomen(), aantalMaanden);

        if(kanMeerWerken && procentOudeInkomen >= 65) return new WGAUitkering(personeelslid.getOudinkomen());
        return new IVAUitkering(personeelslid.getOudinkomen());
    }

}
