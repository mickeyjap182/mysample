package practice.utils.filesystem.file;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {
    @Test
    public void testaaa()  {
//        String filePath = "./input/text.txt";
        StringBuilder filePath = new StringBuilder(new File(".").getAbsoluteFile().getParent());
        filePath.append("/tests/practice/utils/filesystem/file/input/text.txt");
///Users/yoshitaka.toyama/MyPrograms/private/mysample/tests/practice/utils/filesystem/file
        try {
            FileReader f = new FileReader(filePath.toString());
            String s = f.readAllBy(null);
            System.out.println(s);
            assertEquals(s, "abcde,12345,)('0*+'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}