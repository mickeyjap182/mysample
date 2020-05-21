package practice.basicfeature.novice.extendsinterface;

import practice.basicfeature.novice.extendsinterface.interfaces.Myif;
import practice.basicfeature.novice.syntax.MoneyPod;
import practice.utils.logger.TimeLogger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Runner {


    private static TimeLogger logger = TimeLogger.getLogger();

    /** constructor as dynamic initializer */
    public Runner(){
        logger.info("in constructor!");
    }

    /**
     * verify interfaces.
     *
     */
    public void main()  {

        logger.info("startup!! main()!!");

        Animal a = new Animal();

        Myif shiba = a.new Shiba();
        shiba.bark(Myif.getItem("dog"));
        shiba.sleep();

        Myif percian = a.new Percian();
        percian.bark(Myif.getItem("cat"));
        percian.sleep();

    }
}
