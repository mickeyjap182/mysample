package practice.basicfeature.novice.designpetterns.future.abstractfactory;

import practice.basicfeature.novice.designpetterns.future.AbstractFactory;
import practice.basicfeature.novice.designpetterns.future.Factory;

public class AbstractFactoryProvider<T, _T> {

    enum FactoryType{ NOTIFICATIO, }

    /**
     * create new Factory instance.
     * @param
     * @return
     * @throws NoSuchMethodException
     */
    public static AbstractFactory getFactory(Factoriable.TYPE type) throws RuntimeException {
        switch(type)  {
            case ORGNAIZE:
                return new Factory();
            default:
                throw new RuntimeException("no factory Type");
        }
    }

    public static <_Obj> _Obj getSomthing() {
        return (_Obj) null;
    }
}
