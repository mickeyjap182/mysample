package practice.basicfeature.novice.syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitializersTest {
    @Test
    public void testInitializers() {
        // static context
        //
        assertEquals(Initializers.STATUS_MESSAGE.STATIC_INITIALIZER.message(), Initializers.getLastStatusMessage());
        Initializers i = new Initializers();
        assertEquals(Initializers.STATUS_MESSAGE.CONSTRUCTOR.message(), Initializers.getLastStatusMessage());
        assertTrue(true);
    }
}