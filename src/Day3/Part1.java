package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay3.txt"));
        String line;
        int points = 0;
        while ((line = reader.readLine()) != null) {
            String part1 = line.substring(0, line.length()/2);
            String part2 = line.substring(line.length()/2);

            char cha;
            for (int i = 0; i< part1.length() ; i++){
                cha = part1.charAt(i);
                if (part2.contains(cha+"")){
                    points += alphabet.indexOf(cha) + 1;
                    break;
                }
            }
        }
        System.out.println(points);
    }
}
