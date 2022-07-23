package practice.basicfeature.novice.designpetterns.feature.bulider;

import practice.basicfeature.novice.designpetterns.organization.functional.division.Code;
import practice.basicfeature.novice.designpetterns.organization.functional.division.Name;

import java.util.HashMap;
import java.util.Map;

// Executor
// https://qiita.com/disc99/items/840cf9936687f97a482b
public class SetBuilder {

    Map<Code, Name> plan = new HashMap<>();
    Map<Code, Name> admins = new HashMap<>();
    Code companyCode;
    Name companyName;
    public SetBuilder(String code, String name) {

    }

}
