package practice.basicfeature.novice.designpetterns.future;

import practice.basicfeature.novice.designpetterns.future.factory.BussinessUnitOrganization;
import practice.basicfeature.novice.designpetterns.future.factory.FunctionalOrganization;
import practice.basicfeature.novice.designpetterns.future.factory.Organizer;

public class Factory2 implements AbstractFactory<Organizer, Organizer.TYPE> {
    @Override
    public Organizer create(Organizer.TYPE type) {
        switch (type) {
            case FUNCTIONAL:
                return new FunctionalOrganization();
            case BUSSINESSUNIT:
                return new BussinessUnitOrganization();
            default:
                throw new RuntimeException(type.toString() + " is no type.");
        }
    }
}
