package utils;

public class CreateDay {

    public static void CreateFileDay(int day) {

        // How to create a directory in Java
        System.out.println("Create directory : " + "src/Day" + day);

        try {
            WriterDirectory.Write("src/Day" + day + "_notFinished");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }


        // How to write line in file
        String linesPart1 = "package Day" + day + ";\n" +
                "\n" +
                "import java.io.BufferedReader;\n" +
                "import java.io.FileReader;\n" +
                "import java.io.IOException;\n" +
                "\n" +
                "public class Part1 {\n" +
                "    public static void main(String[] args) throws IOException {\n" +
                "        BufferedReader reader = new BufferedReader(new FileReader(\"inputs/inputDay1.txt\"));\n" +
                "        String line;\n" +
                "        while ((line = reader.readLine()) != null) {\n" +
                "           \n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        System.out.println("Create file : " + "src/Day" + day + "/Part1.java");
        WriterFile.Write("src/Day" + day + "_notFinished/Part1.java", linesPart1);

        System.out.println("Create file : " + "src/Day" + day + "/Part2.java");
        String linesPart2 = linesPart1.replace("Part1", "Part2");
        WriterFile.Write("src/Day" + day + "_notFinished/Part2.java", linesPart2);

        // Inputs
        System.out.println("Create file inputs : " + "src/inputs/inputDay" + day + ".txt");
        WriterFile.Write("inputs/inputDay" + day + ".txt", "");
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 25; i++) {
            CreateFileDay(i);
        }
    }
}
