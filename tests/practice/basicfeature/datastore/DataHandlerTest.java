package practice.basicfeature.datastore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataHandlerTest {
    @Test
    public void testTransact(){
        DataHandler d = new DataHandler();
        assertTrue(d.getConnection());
    }
}
