package practice.basicfeature.novice.extendsinterface;

import practice.basicfeature.novice.extendsinterface.parent.Dog;
import practice.basicfeature.novice.extendsinterface.parent.DogGenerator;
import practice.basicfeature.novice.extendsinterface.values.DOG_RULE;
import practice.utils.logger.TimeLogger;

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

        Dog momo = new Dog(DOG_RULE.SHIBA, new DogGenerator(),"もも", "wwowow");
        Dog mikan = new Dog(DOG_RULE.SHIBA, new DogGenerator(),"みかん", "wooon!");
        Dog popo = new Dog(DOG_RULE.PERCIAN, new DogGenerator(), "ポポ", "");

        momo.bark(mikan);
        mikan.bark(momo);
        momo.avoid(mikan);

        popo.sleep();


    }
}
