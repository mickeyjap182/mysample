package practice.basicfeature.novice.designpetterns.solid.s.after.actors;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeFacade;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.Repository;

public class CTO {
    private String name;
    private String code;
    public CTO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public void save(Repository repository, EmployeeData employeeData) {
        EmployeeFacade.save(repository, employeeData);
    }
}
