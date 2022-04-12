package practice.basicfeature.novice.designpetterns.solid.s.after.domains;

import java.io.Serializable;

public class EmployeeData implements Serializable {
    private int id;
    private final String code;
    private final String name;
    private final int unitPrice;
    public EmployeeData(String pCode, String pName, int pUnitPrice) {
        code = pCode;
        name = pName;
        unitPrice = pUnitPrice;

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
