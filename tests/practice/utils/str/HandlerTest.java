package practice.utils.str;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    @Test
    public void test_文字列結合() {
        String result = new Handler("/aaa/bbb/ccc/ddd.csv").tail("/");
        assertEquals("ddd.csv", result);
    }

}