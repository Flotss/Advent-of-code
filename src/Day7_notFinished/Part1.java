package Day7_notFinished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Part1 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay7.txt"));
        String line;
        int sumDirectory = 0;
        Map<String, Integer> directories = new HashMap<>();
        Map<String, ArrayList<String>> subDirectories = new HashMap<>();

        LinkedList<String> currDirectories = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
//            System.out.println(currDirectories);
            if (line.contains("cd")) {
                if (line.contains("cd /")) {
                    currDirectories.clear();
                    currDirectories.add("/");
                    directories.put("/", 0);
                } else if (line.contains("cd ..")) {
                    currDirectories.remove();
                } else {
                    String nameDirectory = line.substring(5);
                    currDirectories.add(nameDirectory);
                }
                continue;
            }

            if (line.contains("dir")) {
                String nameDirectory = line.substring(4);
                if (!directories.containsKey(nameDirectory)) {
                    directories.put(nameDirectory, 0);
                    if (subDirectories.get(currDirectories.getLast()) == null) {
                        ArrayList<String> sub = new ArrayList<>();
                        sub.add(nameDirectory);
                        subDirectories.put(currDirectories.getLast(), sub);
                    } else {
                        subDirectories.get(currDirectories.getLast()).add(nameDirectory);
                    }
                }
                continue;
            }

            for (Integer value : directories.values()) {
                if (value >= 10000) {
                    sumDirectory += value;
                }
            }

        }

        System.out.println(sumDirectory);

    }
}
