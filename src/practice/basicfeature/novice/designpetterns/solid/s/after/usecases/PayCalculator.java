package practice.basicfeature.novice.designpetterns.solid.s.after.usecases;

import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;

import java.io.Serializable;

public class PayCalculator implements Serializable {
    private final EmployeeData employeeData;
    public PayCalculator(EmployeeData pEmployeeData) {
        employeeData = pEmployeeData;
    }
    public int calculatePay(int pDays, int pHoursPerDay, int prescribedWorkingHours) {
        // 所定時間超過分は割増賃金を支払う。
        int overTime = prescribedWorkingHours - pHoursPerDay;
        int times = regularHours(pDays, pHoursPerDay, overTime);
        return employeeData.getUnitPrice() * times;
    }
    private int regularHours(int days, int hoursPerDay, int overTime) {
        int prescribedHours = days * hoursPerDay;
        return overTime > 0
                ? prescribedHours * 125 / 100
                : prescribedHours;

    }
}
