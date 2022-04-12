package practice.basicfeature.novice.designpetterns.solid.s.before.actors;

import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Employee;

public class CFO {
    private String name;
    private String code;
    public CFO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public int calculatePay(Employee employee, int pDay, int pHoursPerDay) {
        return employee.calculatePay(pDay, pHoursPerDay);
    }
}
