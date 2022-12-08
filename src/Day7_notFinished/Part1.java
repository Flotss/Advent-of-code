package Day7_notFinished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Part1 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/inputDay7.txt"));
        String line;

        ArrayList<File> directories = new ArrayList<>();
        LinkedList<String> currDirectories = new LinkedList<>();

        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//            System.out.println(currDirectories);
            if (line.contains("cd")) {
                if (line.contains("cd /")) {
                    currDirectories.clear();
                    currDirectories.add("/");
                } else if (line.contains("cd ..")) {
                    currDirectories.remove();
                } else {
                    String nameDirectory = line.substring(5);
                    currDirectories.add(nameDirectory);
                }
                continue;
            }

            if (line.contains("ls")) continue;

            if (line.contains("dir")) {
                String nameDirectory = line.substring(4);
                Directory directory = new Directory(nameDirectory);
                directories.add(directory);

                Directory currDirectory = new Directory(currDirectories.getLast());
                currDirectory.addFile(directory);
                continue;
            } else {

            }

//            for (Integer value : directories.values()) {
//                if (value >= 10000) {
//                    sumDirectory += value;
//                }
//            }

        }

//        System.out.println(sumDirectory);

    }
}
