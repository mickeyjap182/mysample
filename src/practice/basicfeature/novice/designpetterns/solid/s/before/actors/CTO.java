package practice.basicfeature.novice.designpetterns.solid.s.before.actors;

import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Employee;
import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Repository;

public class CTO {
    private String name;
    private String code;
    public CTO(String pName, String pCode) {
        name = pName;
        code = pCode;
    }
    public void save(Repository repository, Employee employee) {
        employee.save(repository);
    }
}
