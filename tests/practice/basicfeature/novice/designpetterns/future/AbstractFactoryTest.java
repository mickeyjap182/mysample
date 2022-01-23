package practice.basicfeature.novice.designpetterns.future;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.designpetterns.future.abstractfactory.AbstractFactoryProvider;
import practice.basicfeature.novice.designpetterns.future.abstractfactory.Factoriable;
import practice.basicfeature.novice.designpetterns.future.factory.Organizer;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;
import static org.junit.Assert.assertTrue;

public class AbstractFactoryTest {
    @Test
    void testCreate() {
        AbstractFactory<Organizer, Organizer.TYPE> factory = AbstractFactoryProvider.getFactory(Factoriable.TYPE.ORGNAIZE);
        Organizer org = factory.create(Organizer.TYPE.BUSSINESSUNIT);
        org.declare("Good Morning!");
        assertTrue(true);
    }

    public static void echo(Object o) {
        out.print(o.toString());
    }

}