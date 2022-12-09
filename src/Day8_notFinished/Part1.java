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
            int maxI = -1;
            int maxJ = -1;
            int j = line.length() - 1;
            for (int i = 0; i < line.length(); i++) {
                int valI = Integer.parseInt(line.charAt(i) + "");
                int valJ = Integer.parseInt(line.charAt(j) + "");

                if (i == j) {
                    if (valI > maxI) {
                        maxI = valI;
                        treeUsed.add(new Position(i, y));
                    }
                } else {
                    if (valI > maxI) {
                        maxI = valI;

                        treeUsed.add(new Position(i, y));
                    }

                    if (valJ > maxJ) {
                        maxJ = valJ;

                        treeUsed.add(new Position(j, y));
                    }
                }


                j--;
            }
            y++;

        }

        reader = new BufferedReader(new FileReader(INPUT_FILE));
        // We want all columns
        String[] columns = new String[100];
        while ((line = reader.readLine()) != null) {
            for (int columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                columns[columnIndex] = columns[columnIndex] == null ? "" : columns[columnIndex];
                columns[columnIndex] += line.charAt(columnIndex);
            }
        }


        // Now we have all columns in lines
        // But if the tab is not full, we have to remove all the empty columns
        columns = removeEmptyColumns(columns);


        int x = 0;
        for (String s : columns) {
            line = s;
            int maxI = -1;
            int maxJ = -1;
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
