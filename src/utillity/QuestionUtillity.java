package utillity;

import java.util.Scanner;

public class QuestionUtillity {

    public static double inkomenVraag(Scanner scanner, String vraag) {
        double returned = -1;

        while (returned < 0) {
            try {
                returned = Double.parseDouble(askQuestion(scanner, vraag));
            } catch (Exception ignored) {}
        }

        return returned;
    }

    public static int nummerVraag(Scanner scanner, String vraag) {
        int returned = -1;

        while (returned < 0) {
            try {
                returned = Integer.parseInt(askQuestion(scanner, vraag));
            } catch (Exception ignored) {}
        }

        return returned;
    }

    public static boolean jaOfNee(Scanner scanner, String vraag) {
        String response = "";
        while (!antwoordGegeven(response)) {
            response = askQuestion(scanner, vraag);
        }

        return isJa(response);
    }

    public static String askQuestion(Scanner scanner, String vraag) {
        String response = "";

        while (response.equalsIgnoreCase("")) {
            System.out.println();
            System.out.println(vraag);
            response = scanner.nextLine();
        }

        return response;
    }

    private static boolean isJa(String response) {
        return response.equalsIgnoreCase("ja") || response.equalsIgnoreCase("j") || response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
    }


    private static boolean antwoordGegeven(String aws) {
        if(aws.equalsIgnoreCase("ja") || aws.equalsIgnoreCase("j") || aws.equalsIgnoreCase("yes") || aws.equalsIgnoreCase("y")) {
            return true;
        }

        if(aws.equalsIgnoreCase("nee") || aws.equalsIgnoreCase("n") || aws.equalsIgnoreCase("no")) {
            return true;
        }

        return false;
    }
}
