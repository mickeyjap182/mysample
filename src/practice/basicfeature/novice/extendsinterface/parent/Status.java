package practice.basicfeature.novice.extendsinterface.parent;

import practice.basicfeature.novice.extendsinterface.interfaces.Generator;
import practice.basicfeature.novice.extendsinterface.interfaces.StatusGenerator;
import practice.basicfeature.novice.extendsinterface.interfaces.StatusRuleAbility;

public class Status<T> {
    public T identifier;
    public StatusRuleAbility statusRule;

    public static Status newInstance(StatusRuleAbility target, Generator gen)
    {
        Status s = ((StatusGenerator)gen).newStatus(target);
        return s;
    }

    public Status(StatusRuleAbility target, T identifier) {
        this.identifier = identifier;
        this.statusRule = target;
    }
}
