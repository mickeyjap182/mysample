package practice.utils.filesystem.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader implements AutoCloseable{

    private final Path path;

    public FileReader(String filePath) throws FileNotFoundException{
        if (filePath == null) {
            throw new FileNotFoundException("no file path.");
        }

        Path p = new File(filePath).toPath();
        if (!Files.exists(p)) {
            throw new FileNotFoundException("no file. :" + filePath);
        } else if (Files.isDirectory(p)) {
            throw new FileNotFoundException("it is not a file, just a directory. :" + filePath);
        }
        this.path = Paths.get(filePath);

    }
    public String readAllBy(String charset) throws IOException{
        if (charset == null ) charset = "UTF-8";
        try {
            return Files.readString(path, Charset.forName(charset));

        } catch (IOException ex) {
            throw ex;
        }
    }
    public List<String> readAllLineBy(String charset) throws IOException{
        if (charset == null ) charset = "UTF-8";
        try {
            return Files.readAllLines(path, Charset.forName(charset));

        } catch (IOException ex) {
            throw ex;
        }
    }
    public void out() {
        System.out.println(path.getFileName());
    }
    @Override public void close() {

    }
}
