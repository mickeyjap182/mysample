package practice.basicfeature.novice.extendsinterface.values;

import practice.basicfeature.novice.extendsinterface.interfaces.StatusRuleAbility;

public enum DOG_RULE implements StatusRuleAbility {
    SHIBA("1"),
    PERCIAN("2");

    private String code;

    DOG_RULE(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

}
