package practice.basicfeature.novice.designpetterns.solid.s.after.usecases;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;

import java.io.Serializable;

public class HourReporter implements Serializable {
    private final EmployeeData employeeData;
    public HourReporter(EmployeeData pEmployeeData) {
        employeeData = pEmployeeData;
    }
    public int reportHours(int pDays, int pHoursPerDay) {
        return regularHours(pDays, pHoursPerDay);
    }
    private int regularHours(int days, int hoursPerDay) {
        return days * hoursPerDay;
    }
}
