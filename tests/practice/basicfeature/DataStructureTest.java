package practice.basicfeature;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

//import org.junit.jupiter.api.Assertions.assertEquals;

//import practice.basicfeature.DataStructure;

public class DataStructureTest {
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("before Do @once");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("after Do @once");
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        System.out.println("before Do each.");
//    }
//
//    @AfterEach
//    void afterEach() {
//        System.out.println("after Do each.");
//    }
    @Test
    void testmethod() {
        System.out.println("testPlus を実行: 2 + 3 = 5");
        DataStructure d = new DataStructure(2);
        d.add(4);
        // 第1引数: expected 想定される結果
        // 第2引数: actual 実行結果
        // 第3引数: message 失敗時に出力するメッセージ
//        assertEquals(5, d.get(), "2 + 4 = 6 の検証");
        try {
            var decodedUri = URLDecoder.decode("http://sample.com/index.php?p=333&e=あいう","UTF-8");
            System.out.println(decodedUri);
            var te = decodedUri.indexOf("?");
            System.out.println(te);
            decodedUri.substring(0, decodedUri.indexOf(15));
            System.out.println("====decoding====");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();

        }


    }

    @Test
    void testmethod2() {
        System.out.println("testPlus を実行: 2 + 3 = 5");
        DataStructure d = new DataStructure(2);
        d.add(4);
    }

}
