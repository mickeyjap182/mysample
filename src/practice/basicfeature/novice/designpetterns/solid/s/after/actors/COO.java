package practice.basicfeature.novice.designpetterns.solid.s.after.actors;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeFacade;

public class COO {
    private String name;
    private String code;
    public COO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public int reportHours( EmployeeData employeeData, int pDay, int pHoursPerDay) {
        return EmployeeFacade.reportHours(employeeData, pDay, pHoursPerDay);
    }
}
