package practice.basicfeature.novice.features.lib;


import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TimeBoard {


    public boolean isForEmpty() {
        List<String> passwordChangedEmployeeList = new ArrayList<>();
        boolean changePasswordDigest = true;
        if(!CollectionUtils.isEmpty(passwordChangedEmployeeList)) {
            for(String employeeCode : passwordChangedEmployeeList) {
                if(employeeCode.equals("melon")) {
                    changePasswordDigest = false;
                    break;
                }
            }
        }
        return changePasswordDigest;
    }
    public boolean isForNotEmptyHit() {
        List<String> passwordChangedEmployeeList = List.of("banana","orange","grapes");
        boolean changePasswordDigest = true;
        if(!CollectionUtils.isEmpty(passwordChangedEmployeeList)) {
            for(String employeeCode : passwordChangedEmployeeList) {
                if(employeeCode.equals("banana")) {
                    changePasswordDigest = false;
                    break;
                }
            }
        }
        return changePasswordDigest;
    }

    public boolean isForNotEmptyNotHit() {
        List<String> passwordChangedEmployeeList = List.of("banana","orange","grapes");
        boolean changePasswordDigest = true;
        if(!CollectionUtils.isEmpty(passwordChangedEmployeeList)) {
            for(String employeeCode : passwordChangedEmployeeList) {
                if(employeeCode.equals("melon")) {
                    changePasswordDigest = false;
                    break;
                }
            }
        }
        return changePasswordDigest;
    }
    public boolean isStreamEmpty() {
        List<String> passwordChangedEmployeeList = new ArrayList<>();
        boolean changePasswordDigest = CollectionUtils.isEmpty(passwordChangedEmployeeList)
                || passwordChangedEmployeeList.stream().noneMatch(
                employeeCode -> employeeCode.equals("banana")
        );
        return changePasswordDigest;
    }
    public boolean isStreamNotEmptyHit() {
        List<String> passwordChangedEmployeeList = List.of("banana","orange","grapes");
        boolean changePasswordDigest = CollectionUtils.isEmpty(passwordChangedEmployeeList)
                || passwordChangedEmployeeList.stream().noneMatch(
                employeeCode -> employeeCode.equals("banana")
        );
        return changePasswordDigest;
    }
    public boolean isStreamNotEmptyNotHit() {
        List<String> passwordChangedEmployeeList = List.of("banana","orange","grapes");
        boolean changePasswordDigest = CollectionUtils.isEmpty(passwordChangedEmployeeList)
                || passwordChangedEmployeeList.stream().noneMatch(
                employeeCode -> employeeCode.equals("melon")
        );
        return changePasswordDigest;
    }

    public void timeTest() {
//        Time time = new Time();
    }

    public void clockTest() {
//        Clock c = new Clock();
    }

}
