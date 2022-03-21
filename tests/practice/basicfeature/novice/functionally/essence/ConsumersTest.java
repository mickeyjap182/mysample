package practice.basicfeature.novice.functionally.essence;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumersTest {
    @Test
    public void testConsumers() {
        Consumers c = new Consumers();
        c.printSum(7, 10);
    }

}