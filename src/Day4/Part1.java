package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay4.txt"));
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");

            // Part 1
            String[] part1 = parts[0].split("-");
            ArrayList<Integer> paire1 = createList(part1);

            // Part 2
            String[] part2 = parts[1].split("-");
            ArrayList<Integer> paire2 = createList(part2);

            if (paire2.containsAll(paire1)) {
                count++;
            }else if (paire1.containsAll(paire2)) {
                count++;
            }

        }
        System.out.println(count);
    }


    private static ArrayList<Integer> createList(String[] part) {
        ArrayList<Integer> list = new ArrayList<>();
        int beginSection = Integer.parseInt(part[0] + "");
        int endSection = Integer.parseInt(part[1] + "");

        for (int i = beginSection; i <= endSection; i++) {
            list.add(i);
        }
        return list;
    }
}
