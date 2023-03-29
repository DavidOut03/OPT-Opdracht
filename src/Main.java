import kenmerken.Kenmerk;
import kenmerken.KenmerkenLijst;
import personen.Personeelslid;
import processors.InkomensBerekener;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KenmerkenLijst kenmerkenLijst = new KenmerkenLijst();
        kenmerkenLijst.setUpDefaultKenmerkenLijst();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat is het e-mail adres van het personeelslid?");
        String email = scanner.nextLine();

        System.out.println("Wat is het huidige inkomen van het personeelslid?");
        double oudInkomen = scanner.nextDouble();

        Personeelslid personeelslid = new Personeelslid(email, oudInkomen);

        for (int i = 0; i < kenmerkenLijst.getKenmerkList().size(); i++) {
            System.out.println((i + 1) + " " + kenmerkenLijst.getKenmerkList().get(i).getNaam());
        }

        System.out.println();


        int kenmerkNummer = 10;
        while (kenmerkNummer != 0) {
            System.out.println("Wilt u een kenmerk selecteren van het personeelslid?");
            System.out.println("Selecteer 0 als u geen kenmerk meer wilt toevoegen.");
            kenmerkNummer = scanner.nextInt();

            if(kenmerkNummer <= 0) continue;

            Kenmerk kenmerk = kenmerkenLijst.getKenmerkList().get(kenmerkNummer -1);
            if(kenmerk == null) {
                System.out.println("Kenmerk niet gevonden type hem alstublieft nog een keer in.");
                continue;
            }

            personeelslid.addKenmerk(kenmerk);
        }

        InkomensBerekener gegevensReceiver = new InkomensBerekener(personeelslid, null);
        gegevensReceiver.berekenInkomen();
        System.out.println("Het nieuwe inkomen is: " + personeelslid.getNieuwInkomen().getFormatedInkomen());


    }


}