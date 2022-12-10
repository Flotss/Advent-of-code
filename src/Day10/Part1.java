package Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> cycle = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay9.txt"));
        String line;

        // Add all cycle
        // If cycle is noop, add 0
        // If cycle is addx, add 0 then add x
        cycle.add(1);
        while ((line = reader.readLine()) != null) {
            if (line.contains("noop")) {
                cycle.add(0);
            }

            if (line.contains("addx")) {
                cycle.add(0);
                cycle.add(Integer.parseInt(line.split(" ")[1]));
            }
        }


        // Do an cycleUpdated to have the sum of cycles by cycle
        ArrayList<Integer> cycleUpdated = new ArrayList<>(cycle.size());
        int amount = 0;
        for (int i = 0; i < cycle.size(); i++) {
            cycleUpdated.add(i, amount + cycle.get(i));
            amount += cycle.get(i);
        }

        // Find the sum of (20, 40, 80, 120, 160, 200...)
        amount = 0;
        for (int i = 0; i < cycleUpdated.size(); i++) {
            if ((i - 19) % 40 == 0) {
                amount += cycleUpdated.get(i) * (i + 1);
            }
        }

        System.out.println(amount);
    }
}
