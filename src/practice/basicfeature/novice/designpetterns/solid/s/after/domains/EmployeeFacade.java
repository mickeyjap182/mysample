package practice.basicfeature.novice.designpetterns.solid.s.after.domains;

import practice.basicfeature.novice.designpetterns.solid.s.after.usecases.EmployeeSaver;
import practice.basicfeature.novice.designpetterns.solid.s.after.usecases.HourReporter;
import practice.basicfeature.novice.designpetterns.solid.s.after.usecases.PayCalculator;

import java.io.Serializable;

public class EmployeeFacade implements Serializable {
    public static int calculatePay(EmployeeData employeeData, int pDays, int pHoursPerDay, int prescribedWorkingHours) {
        return new PayCalculator(employeeData).calculatePay(pDays, pHoursPerDay, prescribedWorkingHours);
    }
    public static int reportHours(EmployeeData employeeData, int pDays, int pHoursPerDay) {
        return new HourReporter(employeeData).reportHours(pDays, pHoursPerDay);
    }

    public static EmployeeData save(Repository repository, EmployeeData employeeData) {
        return new EmployeeSaver(employeeData).saveEmployee(repository);
    }
}
