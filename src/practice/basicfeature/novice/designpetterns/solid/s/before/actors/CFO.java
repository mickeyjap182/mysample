package practice.basicfeature.novice.designpetterns.solid.s.before.actors;

import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Employee;

public class CFO {
    private String name;
    private String code;
    public CFO() {

    }
    public void main() {
        new Employee().reportHours();
    }
}
