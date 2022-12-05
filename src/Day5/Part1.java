package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Part1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day5/text.txt"));
        String line;

        // Initialize the map
        Map<Integer, Stack<Character>> map = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            map.put(i, new Stack<>());
        }

        // Generate the stacks
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }

            int index = 1;
            for (int i = 1; i <= 9; i++) {
                // Verification
                if (line.charAt(index) != ' ' && !Character.isDigit(line.charAt(index))) {
                    map.get(i).add(0, line.charAt(index));
                }
                index += 4;
            }
        }

        while ((line = reader.readLine()) != null) {
            String[] split = line.split(" ");
            int nbCaisse = Integer.parseInt(split[1]);
            int pile1 = Integer.parseInt(split[3]);
            int pile2 = Integer.parseInt(split[5]);


            for (int i = 0; i < nbCaisse; i++) {
                char character = map.get(pile1).pop();
                map.get(pile2).push(character);
            }
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println("Pile " + i + " : " + map.get(i));
        }
    }

}
