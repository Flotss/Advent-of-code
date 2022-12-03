package Day1;

import java.io.*;

public class Part1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day1/text.txt"));
        int max = 0;
        int somme = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                if (somme > max) {
                    max = somme;
                }
                somme = 0;
            }else{
                int number = Integer.parseInt(line);
                somme += number;
            }
        }
        System.out.println(max);
    }
}
