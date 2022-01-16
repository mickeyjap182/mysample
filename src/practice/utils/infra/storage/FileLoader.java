package practice.utils.infra.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
    public final String filePath;
    public FileLoader(String path) {
        filePath = path;
    }

    public String read() throws IOException {
        System.out.println(filePath);
        try (BufferedReader b = new BufferedReader(new FileReader(filePath))) {
            return b.readLine();
        } catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
