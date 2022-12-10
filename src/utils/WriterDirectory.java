package utils;

import java.io.File;

public class WriterDirectory {

    public static void Write(String path) throws RuntimeException {
        File newDirectory = new File(path);

        // Check if the directory puzzle solution already exists
        String pathSolutionDirectory = path.replace("_notFinished", "");
        File solutionDirectoryAvailable = new File(pathSolutionDirectory);

        if (solutionDirectoryAvailable.exists()) {
            throw new RuntimeException("Directory already exists: " + solutionDirectoryAvailable);
        }


        if (newDirectory.exists()) {
            if (newDirectory.listFiles().length > 0) {
                throw new RuntimeException("Directory is not empty " + newDirectory);
            }
        } else {
            if (!newDirectory.mkdir()) {
                throw new RuntimeException("Directory creation failed " + newDirectory);
            }
        }
    }
}
