package Day7_notFinished;

import java.util.ArrayList;

public class Directory extends File {

    ArrayList<File> files = new ArrayList<>();

    public Directory(String name) {
        super(name, 0);
    }


    public void addFile(File file) {
        files.add(file);
    }

    public long size() {
        long size = 0;
        for (File file : files) {
            size += file.size();
        }

        return size;
    }
}
