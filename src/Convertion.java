package src;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;


public class Convertion {

    public static ArrayList<ArrayList<Tuile>> parseFile(Integer fileNumber){
        boolean start = true;
        ArrayList<ArrayList<Tuile>> tuiles = new ArrayList<>();

        File gr = new File("levels\\level"+ fileNumber.toString() +".nrg");

        try (Scanner scanFile = new Scanner(gr)) {
            scanFile.useDelimiter(System.getProperty("line.separator"));
            while (scanFile.hasNext()) {
                String string = scanFile.nextLine();
                if(!start){
                    tuiles.add(Convertion.parseString(string));
                }
                else start = false;
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

        return tuiles;
    }
    
    public static ArrayList<Tuile> parseString(String input) {
        ArrayList<Tuile> result = new ArrayList<Tuile>();
        String[] symbols = input.split(" ");
        String composant = null;
        ArrayList<Integer> connexions = new ArrayList<>();
        for (String symbol : symbols) {
            if (isLetter(symbol)) {
                if (composant != null) {
                    result.add(new Tuile(composant, connexions));
                }
                composant = symbol;
                connexions = new ArrayList<>();
            } else if (isNumber(symbol)) {
                connexions.add(Integer.parseInt(symbol));
            }
        }
        if (composant != null) {
            result.add(new Tuile(composant, connexions));
        }
        return result;
    }
    
    private static boolean isLetter(String s) {
        return s.length() == 1 && (s.equals(".") || s.equals("S") || s.equals("L") || s.equals("W"));
    }
    
    private static boolean isNumber(String s) {
        try {
            Integer i = Integer.parseInt(s);
            if (i>0 && i<=6)
                return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}