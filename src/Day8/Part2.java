package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Part2 {

    private static final String INPUT_FILE = "inputs/inputDay8.txt";

    public static void main(String[] args) throws IOException {
        Map<Position, Integer> grid = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
        String line;


        int y = 0;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                int valI = Integer.parseInt(line.charAt(i) + "");

                grid.put(new Position(i, y), valI);
            }
            y++;
        }


        Position theBestPosition = null;
        int maxScenicScore = -1;
        for (Position pos : grid.keySet()) {
            int leftCount = 0;
            int rightCount = 0;
            int upCount = 0;
            int downCount = 0;
            int heightHome = grid.get(pos);

            for (int left = pos.x - 1; left >= 0; left--) {
                if (grid.get(new Position(left, pos.y)) < heightHome) {
                    leftCount++;
                } else {
                    leftCount++;
                    break;
                }
            }

            for (int right = pos.x + 1; right <= 98; right++) {
                if (grid.get(new Position(right, pos.y)) < heightHome) {
                    rightCount++;
                } else {
                    rightCount++;
                    break;
                }
            }

            for (int up = pos.y - 1; up >= 0; up--) {
                if (grid.get(new Position(pos.x, up)) < heightHome) {
                    upCount++;
                } else {
                    upCount++;
                    break;
                }
            }

            for (int down = pos.y + 1; down <= 98; down++) {
                if (grid.get(new Position(pos.x, down)) < heightHome) {
                    downCount++;
                } else {
                    downCount++;
                    break;
                }
            }

            int scenicScore = leftCount * rightCount * upCount * downCount;
            if (scenicScore > maxScenicScore) {
                maxScenicScore = scenicScore;
                theBestPosition = pos;
            }

        }
        System.out.println("The best place : " + theBestPosition + " highest scenic score: " + maxScenicScore);

    }

    public record Position(int x, int y) implements Comparable<Position> {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position position)) return false;
            return x() == position.x() && y() == position.y();
        }

        @Override
        public int hashCode() {
            return Objects.hash(x(), y());
        }

        @Override
        public String toString() {
            return "Position : x = " + x + " y = " + y;
        }

        @Override
        public int compareTo(Position o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
