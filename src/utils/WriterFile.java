package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterFile {
    public static void Write(String s, String lines) {
        try {
            File file = new File(s);
            if (file.exists()) {
                throw new RuntimeException("File already exists: " + file);
            }
            PrintWriter output = new PrintWriter(file);
            output.println(lines);
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
