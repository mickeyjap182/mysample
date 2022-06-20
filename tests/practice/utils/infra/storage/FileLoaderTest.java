package practice.utils.infra.storage;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoaderTest {

    @Test
    public void testSome() {
        String s = System.getProperty("user.dir");
        Path p = Paths.get(s,  "tests", "resources", "files", "ascii.txt");

        FileLoader f = new FileLoader(p.toAbsolutePath().toString());
        try {
            String lines = f.read();
            assertEquals("abcde, fghij, klmno",lines);
            assertTrue(true);

        } catch(Exception e) {
            System.out.println(f.filePath);
            assertTrue(false);
        }
    }


}