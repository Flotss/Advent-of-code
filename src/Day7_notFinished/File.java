package Day7_notFinished;

public class File {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String name() {
        return name;
    }

    public long size() {
        return size;
    }
}
