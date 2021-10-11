package practice.basicfeature.novice.extendsinterface.parent;

import practice.basicfeature.novice.extendsinterface.BasicStatus;
import practice.basicfeature.novice.extendsinterface.interfaces.StatusGenerator;
import practice.basicfeature.novice.extendsinterface.values.DOG_RULE;

public class DogGenerator implements StatusGenerator<DOG_RULE, String> {

    @Override
    public BasicStatus newStatus(DOG_RULE type) {
        return new BasicStatus(type, getStatusIdentifier(type));
    }
    @Override
    public String getStatusIdentifier(DOG_RULE type) {
        switch (type) {
            case SHIBA:
            case PERCIAN:
                return type.getCode();
            default:
                throw new RuntimeException("=== runtime exception. ===");
        }
    }
}
