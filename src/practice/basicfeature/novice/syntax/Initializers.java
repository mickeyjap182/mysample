package practice.basicfeature.novice.syntax;

import practice.utils.logger.TimeLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * 製造業 Initializer practice for Manufacturing industry.
 */
public class Initializers extends ParentInitializers {

    public enum STATUS_MESSAGE {
        STATIC_INITIALIZER( "****  static initializer!"),
        PARENT_INITIALIZER("no args no message ParentInitializers."),
        INSTANCE_INITIALIZER("**** instance initializer!"),
        INITIAL_BLOCK("**** run initial block"),
        CONSTRUCTOR("**** in constructor!");
        private String message;
        STATUS_MESSAGE(String aMessage) {
            message = aMessage;
        }
        public String message() {
            return this.message;
        }
    }
    public static String getLastStatusMessage() {
        return lastStatusMessage;
    }

    /** constructor as dynamic initializer */
    public Initializers(){
        lastStatusMessage = STATUS_MESSAGE.CONSTRUCTOR.message();
        logger.info(String.format("message: %s num: %d", lastStatusMessage, num++));
    }

    /** instance initializer */
    List<String> numbers = new ArrayList<>(); {
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");

        lastStatusMessage = STATUS_MESSAGE.INSTANCE_INITIALIZER.message();

        logger.info(String.format("message: %s num: %d", lastStatusMessage,  num++));

    }


    {
        lastStatusMessage = STATUS_MESSAGE.INITIAL_BLOCK.message();
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
        lastStatusMessage = STATUS_MESSAGE.STATIC_INITIALIZER.message();
        if (logger == null) logger = TimeLogger.getLogger();
        logger.info(String.format("message: %s num: %d ",lastStatusMessage ,num++));
    }

    /** static member */
    private static String[] learnTask;
    /** instance field */
    private String currentTerm;

    enum TaxPattern {
        PER_UNIT, // ユニット単価ごとに税率算出
        AFTER_AMOUNT;  // 最後に算出
    }
    public class Rot {
        private final String rotSerialCode;
        private final long unitSize;
        public Rot(String pRotSerialCode, int pUnitSize) {
            rotSerialCode = pRotSerialCode;
            unitSize = pUnitSize;
        }
    }
    /** inner class for calculating Price. */
    public strictfp class Price {
        private final String title;
        private final double taxLate;
        private long unitPrice;
        private Rot rot;
        private double value;

        public Price(double pTaxLate) {
            title = this.getClass().getName();
            taxLate = pTaxLate;
        }
        public void calc(long pUnitPrice, Rot pRot) {
            unitPrice = pUnitPrice;
            rot = pRot;
            value = unitPrice * num;
        }
    }

}
class ParentInitializers {
    protected static int num = 1;

    protected static TimeLogger logger;

    public ParentInitializers() {
        this(Initializers.STATUS_MESSAGE.PARENT_INITIALIZER.message()); // It must be top of method.
    }

    public ParentInitializers(String message) {
        String logstatus = message == null ? "no message" : message;
        if (logger == null) logger = TimeLogger.getLogger();

        logger.info(String.format("message: %s num: %d", logstatus ,  num++));
    }
}

class Employee {
    private List<Role> roles;
    private final String givenName;
    private final String middleName;
    private final String familyName;
    /** TODO parts*/
    private transient List<String> socialSecurityNumber = new ArrayList<>();
    /** TODO */
    private volatile long id = 102L;
    public Employee(String pGivenName, String pMiddleName, String pFamilyName) {
        givenName = pGivenName;
        middleName = pMiddleName;
        familyName = pFamilyName;
    }

}

class Role {

}
