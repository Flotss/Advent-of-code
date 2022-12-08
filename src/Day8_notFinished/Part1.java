package Day8_notFinished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Part1 {

    private static final String INPUT_FILE = "inputs/inputDay8.txt";

    public static void main(String[] args) throws IOException {
        Set<Position> treeUsed = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
        String line;

        int y = 0;
        while ((line = reader.readLine()) != null) {
            int maxI = 0;
            int maxJ = 0;
            int j = line.length() - 1;
            for (int i = 0; i < line.length(); i++) {
                System.out.println("i: " + i + " j: " + j);
                int valI = Integer.parseInt(line.charAt(i) + "");
                int valJ = Integer.parseInt(line.charAt(j) + "");

                if (i == j) {
                    System.out.println("i == j");
                    if (valI > maxI) {
                        maxI = valI;
                        treeUsed.add(new Position(i, y));
                    }
                } else {
                    if (valI > maxI) {
                        System.out.println("valI > maxI" + " valI: " + valI + " maxI: " + maxI);
                        maxI = valI;

                        treeUsed.add(new Position(i, y));
                    }

                    if (valJ > maxJ) {
                        System.out.println("valJ > maxJ" + " valJ: " + valJ + " maxJ: " + maxJ);
                        maxJ = valJ;

                        treeUsed.add(new Position(j, y));
                    }
                }


                j--;
            }
            y++;

        }


        System.out.println("\n\n");
        reader = new BufferedReader(new FileReader(INPUT_FILE));
        // We want all columns
        String[] lines = new String[100];
        while ((line = reader.readLine()) != null) {
            for (int columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                lines[columnIndex] = lines[columnIndex] == null ? "" : lines[columnIndex];
                lines[columnIndex] += line.charAt(columnIndex);
            }
        }


        // Now we have all columns in lines
        // But if the tab is not full, we have to remove all the empty columns
        lines = removeEmptyColumns(lines);


        int x = 0;
        for (String s : lines) {
            line = s;
            int maxI = 0;
            int maxJ = 0;
            int j = line.length() - 1;
            for (int i = 0; i < line.length(); i++) {
                int valI = Integer.parseInt(line.charAt(i) + "");
                int valJ = Integer.parseInt(line.charAt(j) + "");

                if (i == j) {
                    if (valI > maxI) {
                        maxI = valI;
                        treeUsed.add(new Position(x, i));
                    }
                } else {
                    if (valI > maxI) {

                        maxI = valI;
                        treeUsed.add(new Position(x, i));
                    }

                    if (valJ > maxJ) {
                        maxJ = valJ;
                        treeUsed.add(new Position(x, j));
                    }
                }

                j--;
            }

            x++;
        }
        System.out.println(treeUsed.size());

    }

    private static String[] removeEmptyColumns(String[] lines) {
        int i = 0;
        while (lines[i] != null) {
            i++;
        }

        String[] newLines = new String[i];
        System.arraycopy(lines, 0, newLines, 0, newLines.length);

        return newLines;
    }


    public static class Position implements Comparable<Position> {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position position)) return false;
            return getX() == position.getX() && getY() == position.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
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
