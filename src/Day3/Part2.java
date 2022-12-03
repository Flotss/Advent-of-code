package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Part2 {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day3/text.txt"));
        String line;
        int points = 0;
        while ((line = reader.readLine()) != null) {
            String line1 = line+"";
            String line2 = reader.readLine();
            String line3 = reader.readLine();

            for (int i = 0; i < line1.length(); i++) {
                char cha = line1.charAt(i);
                if (line2.contains(cha + "") && line3.contains(cha + "")) {
                    points += alphabet.indexOf(cha) + 1;
                    break;
                }
            }
        }
        System.out.println(points);
    }
}
