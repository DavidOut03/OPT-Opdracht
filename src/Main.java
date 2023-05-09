

import kenmerken.Kenmerk;
import kenmerken.KenmerkenLijst;
import personen.Arbeidsdeskundige;
import personen.Personeelslid;
import processors.InkomensBerekener;

import javax.mail.MessagingException;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws MessagingException {

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

            Kenmerk kenmerk = KenmerkenLijst.getKenmerkList().get(kenmerkNummer -1);
            if(kenmerk == null) {
                System.out.println("Kenmerk niet gevonden type hem alstublieft nog een keer in.");
                continue;
            }

            personeelslid.addKenmerk(kenmerk);
        }

        InkomensBerekener gegevensReceiver = new InkomensBerekener(personeelslid);
        double nieuwInkomen = gegevensReceiver.berekenInkomen();

        System.out.println("Het nieuwe inkomen is: " + personeelslid.getNieuwInkomen().getFormatedInkomen());


            String aws = "";
            while (!jaOfNee(aws)) {
                System.out.println();
                System.out.println("Wilt u een email naar u de arbeidsdeskundige sturen?");
                aws = scanner.nextLine();
            }

            if(aws.equalsIgnoreCase("ja") || aws.equalsIgnoreCase("j") || aws.equalsIgnoreCase("yes") || aws.equalsIgnoreCase("y")) {
                System.out.println("Wat is het email adress van de arbeidsdeskundige?");
                String abEmail = scanner.nextLine();
                Arbeidsdeskundige arbeidsdeskundige = new Arbeidsdeskundige(abEmail, personeelslid);
                arbeidsdeskundige.setVerstuurNaarArbeidsdeskundige(true);
                arbeidsdeskundige.verstuurEmail();
            }

            aws = "";
            while (!jaOfNee(aws)) {
                System.out.println();
                System.out.println("Wilt u een email sturen naar het personeelsid?");
                aws = scanner.nextLine();
            }

            if(aws.equalsIgnoreCase("ja") || aws.equalsIgnoreCase("j") || aws.equalsIgnoreCase("yes") || aws.equalsIgnoreCase("y")) {
                personeelslid.verstuurEmail();
            }

    }



    private static boolean jaOfNee(String aws) {
        if(aws.equalsIgnoreCase("ja") || aws.equalsIgnoreCase("j") || aws.equalsIgnoreCase("yes") || aws.equalsIgnoreCase("y")) {
            return true;
        }

        if(aws.equalsIgnoreCase("nee") || aws.equalsIgnoreCase("n") || aws.equalsIgnoreCase("no")) {
            return true;
        }

        return false;
    }


}