package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Part2 {
    public static void main(String[] args) throws IOException {
        TreeSet<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BufferedReader reader = new BufferedReader(new FileReader("src/Day1/text.txt"));
        int somme = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                numbers.add(somme);
                somme = 0;
            }else{
                int number = Integer.parseInt(line);
                somme += number;
            }
        }


        int calories = 0;
        for (int i = 0; i < 3; i++) {
            calories += numbers.pollFirst();
        }
        System.out.println(calories);
    }
}
