package practice.basicfeature.novice.designpetterns.solid.s.after.actors;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeFacade;

public class CFO {
    private String name;
    private String code;
    public CFO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public int calculatePay(EmployeeData employeeData, int pDay, int pHoursPerDay, int prescribedWorkingHours) {
        return EmployeeFacade.calculatePay(employeeData, pDay, pHoursPerDay, prescribedWorkingHours);
    }
}
