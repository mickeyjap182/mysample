package practice.basicfeature.novice.designpetterns.solid.s.after.usecases;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.Repository;

import java.io.Serializable;

public class EmployeeSaver implements Serializable {
    private final EmployeeData employeeData;
    public EmployeeSaver(EmployeeData pEmployeeData) {
        employeeData = pEmployeeData;
    }
    public EmployeeData saveEmployee(Repository repository) {
        repository.saveEmployee(employeeData);
        return repository.getEmployee(employeeData.getCode());
    }
}
