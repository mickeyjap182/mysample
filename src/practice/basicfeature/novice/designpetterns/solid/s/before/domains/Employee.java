package practice.basicfeature.novice.designpetterns.solid.s.before.domains;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private final String code;
    private final String name;
    private final int unitPrice;
    public Employee(String pCode, String pName, int pUnitPrice) {
        code = pCode;
        name = pName;
        unitPrice = pUnitPrice;

    }
    public int calculatePay(int pDays, int pHoursPerDay) {
        int times = regularHours(pDays, pHoursPerDay);
        return unitPrice * times;
    }
    public int reportHours(int pDays, int pHoursPerDay) {
        return regularHours(pDays, pHoursPerDay);
    }
    public Employee save(Repository repository) {
        repository.saveEmployee(this);
        return repository.getEmployee(this.code);
    }
    private int regularHours(int days, int hoursPerDay) {
        // TODO: defferent
        return days * hoursPerDay;
    }
    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public void setId(int pId) {
        id = pId;
    }
}
