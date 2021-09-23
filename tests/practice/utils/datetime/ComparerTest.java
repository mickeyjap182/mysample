package practice.utils.datetime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComparerTest {

    @Test
    void testThrowsException() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            Assertions.assertEquals("hekko", new Comparer().findMessage());
        });
    }}