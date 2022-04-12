package practice.basicfeature.novice.designpetterns.solid.s.before.actors;

import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Employee;

public class COO {
    private String name;
    private String code;
    public COO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public int reportHours(Employee employee, int pDay, int pHoursPerDay) {
        return employee.reportHours(pDay, pHoursPerDay);
    }
}
