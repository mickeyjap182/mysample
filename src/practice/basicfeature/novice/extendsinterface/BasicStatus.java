package practice.basicfeature.novice.extendsinterface;

import practice.basicfeature.novice.extendsinterface.interfaces.StatusRuleAbility;
import practice.basicfeature.novice.extendsinterface.parent.Status;

public class BasicStatus extends Status {
    public BasicStatus(StatusRuleAbility target, String code) {
        super(target, code);
    }
}
