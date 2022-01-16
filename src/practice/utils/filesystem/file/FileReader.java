package practice.utils.filesystem.file;

import java.nio.file.Paths;
public class FileReader {

    private final String path;

    public FileReader(String filePath) {
        this.path = filePath;

    }
    public void out() {
        System.out.println(Paths.get(path).getFileName());
    }
}
