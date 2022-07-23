package practice.basicfeature.novice.designpetterns.feature;

import practice.basicfeature.novice.designpetterns.feature.factory.BussinessUnitOrganization;
import practice.basicfeature.novice.designpetterns.feature.factory.FunctionalOrganization;
import practice.basicfeature.novice.designpetterns.feature.factory.Organizer;

public class Factory {
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
