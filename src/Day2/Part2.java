package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Part2 {

    private final static int win = 6;
    private final static int lose = 0;
    private final static int draw = 3;

//    rock = "A";
//    paper = "B";
//    scissors = "C";

    private final static int scoreRock = 1;
    private final static int scorePaper = 2;
    private final static int scoreScissors = 3;

    private final static HashMap<String, Integer> result = new HashMap<>();
    private final static HashMap<String, Integer> strategie = new HashMap<>();

    private static void initMap(){
        result.put("A X", scoreScissors);
        result.put("A Y", scoreRock);
        result.put("A Z", scorePaper);
        result.put("B X", scoreRock);
        result.put("B Y", scorePaper);
        result.put("B Z", scoreScissors);
        result.put("C X", scorePaper);
        result.put("C Y", scoreScissors);
        result.put("C Z", scoreRock);

        strategie.put("X", lose);
        strategie.put("Y", draw);
        strategie.put("Z", win);
    }


    public static void main(String[] args) throws IOException {
        initMap();
        BufferedReader reader = new BufferedReader(new FileReader("src/Day2/text.txt"));
        String line;
        int score = 0;
        while ((line = reader.readLine()) != null) {

            String[] split = line.split(" ");
            String whatFinish = split[1];

            score += result.get(line);
            score += strategie.get(whatFinish);
        }

        System.out.println(score);
    }


}
