package practice.basicfeature.novice.designpetterns.future;


import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.designpetterns.future.factory.Organizer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryTest {
    @Test
    void testCreate() {
        Organizer notice = new Factory().create(Organizer.TYPE.FUNCTIONAL);
        notice.declare("Good Morning!");

        Organizer notice2 = new Factory().create(Organizer.TYPE.BUSSINESSUNIT);
        notice.declare("See you Next Week!");

        assertTrue(true);
    }


}