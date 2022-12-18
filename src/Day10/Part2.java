package Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> cycle = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay10.txt"));
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


        ArrayList<Integer> cycle20_40_80 = new ArrayList<>();
        for (int i = 0; i < cycleUpdated.size(); i++) {
            if ((i - 19) % 40 == 0) {
                System.out.println(cycleUpdated.get(i));
                cycle20_40_80.add(cycleUpdated.get(i));
            }
        }

        int widthSprite = 3;
        int witdhLine = 40;
        int heightScreen = 6;

        for (int i = 0; i < heightScreen; i++) {
            int amountLine = cycle20_40_80.get(i);
            if (amountLine == 0) {
                System.out.print("##");
                for (int j = 1; j < witdhLine; j++) {
                    System.out.print(".");
                }
            } else {
                for (int j = 0; j < witdhLine; j++) {
                    if (amountLine - 1 == j) {
                        for (int k = 0; k < widthSprite; k++) {
                            System.out.print("#");
                        }
                    } else {
                        System.out.print(".");
                    }
                }
            }
            System.out.println();
        }
    }
}
