package practice.basicfeature.novice.syntax;

import practice.utils.logger.TimeLogger;

import java.util.ArrayList;
import java.util.List;

public class Initializers extends ParentInitializers {

    /** constructor as dynamic initializer */
    public Initializers(){
        lastStatusMessage = "**** in constructor!";
        logger.info(String.format("message: %s num: %d", lastStatusMessage, num++));
    }

    /** instance initializer */
    List<String> numbers = new ArrayList<>(); {
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");

        lastStatusMessage = "**** instance initializer!";

        logger.info(String.format("message: %s num: %d", lastStatusMessage,  num++));

    }


    {
        lastStatusMessage = "**** run initial block";
        logger = TimeLogger.getLogger();
        logger.info(String.format("message: %s num: %d",lastStatusMessage ,  num++));
    }

    /** if you use method or property, it must be before static initializer */
    protected static String lastStatusMessage = "no initialize";
    /** static initializer */
    static {
        learnTask = new String[] {
                "initializer",
                "staticInitializer",
                "classLoader",
                "anonymousClass",
                "anonymousMethod",
        };
        lastStatusMessage = "****  static initializer!";
        if (logger == null) logger = TimeLogger.getLogger();
        logger.info(String.format("message: %s num: %d ",lastStatusMessage ,num++));
    }

    private static String[] learnTask;
}
class ParentInitializers {
    protected static int num = 1;

    protected static TimeLogger logger;

    public ParentInitializers() {
        this("**** no args no message ParentInitializers."); // It must be top of method.
    }

    public ParentInitializers(String message) {
        String logstatus = message == null ? "no message" : message;
        if (logger == null) logger = TimeLogger.getLogger();

        logger.info(String.format("message: %s num: %d", logstatus ,  num++));
    }

}

