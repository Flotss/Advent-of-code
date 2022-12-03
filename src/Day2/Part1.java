package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    private final static int win = 6;
    private final static int lose = 0;
    private final static int draw = 3;

    private final static String rock = "A";
    private final static String paper = "B";
    private final static String scissors = "C";

    private final static int scoreRock = 1;
    private final static int scorePaper = 2;
    private final static int scoreScissors = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day2/text.txt"));
        String line;
        int score = 0;
        while ((line = reader.readLine()) != null) {
            line = line.replace("X", "A");
            line = line.replace("Y", "B");
            line = line.replace("Z", "C");


            String[] split = line.split(" ");
            String player1 = split[0];
            String player2 = split[1];
            if (player1.equals(player2)) {
                score += draw;
            } else if (player1.equals(rock)) {
                if (player2.equals(paper)) {
                    score += win;
                } else {
                    score += lose;
                }
            } else if (player1.equals(paper)) {
                if (player2.equals(scissors)) {
                    score += win;
                } else {
                    score += lose;
                }
            } else if (player1.equals(scissors)) {
                if (player2.equals(rock)) {
                    score += win;
                } else {
                    score += lose;
                }
            }

            score += switch (player2) {
                case rock -> scoreRock;
                case paper -> scorePaper;
                case scissors -> scoreScissors;
                default -> 0;
            };
        }

        System.out.println(score);
    }

}
