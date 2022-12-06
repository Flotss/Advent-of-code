package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay6.txt"));
        String line = reader.readLine();

        int index = 0;
        ArrayList<String> ens = new ArrayList<>();

        boolean trouve = false;
        for (int i = 0; i < line.length() && !trouve; i++) {
            if (ens.size() < 14) {
                ens.add(line.charAt(i) + "");

            } else {
                ens.add(line.charAt(i) + "");
                ens.remove(0);
            }
            index++;

            if (ens.size() == 14)
                trouve = notEqualsCharacters(ens);


        }
        System.out.println(index);
    }

    private static boolean notEqualsCharacters(ArrayList<String> ens) {
        boolean trouve = true;

        for (int i = 0; i < ens.size(); i++) {
            for (int j = i + 1; j < ens.size(); j++) {
                if (ens.get(i).equals(ens.get(j))) {
                    trouve = false;
                    break;
                }
            }
        }
        return trouve;
    }
}
