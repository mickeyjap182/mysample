package practice.basicfeature;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(5, d.get(), "2 + 4 = 6 の検証");
    }

}
