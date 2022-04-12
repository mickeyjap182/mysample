package practice.basicfeature.novice.designpetterns.solid.s.after.domains;

import java.util.concurrent.ConcurrentHashMap;

public class Repository {
    private static Repository repository;
    ConcurrentHashMap<String, EmployeeData> employeeData;

    private Repository(){
        employeeData = new ConcurrentHashMap<>();
    }

    /**
     * シングルトン
     * @return
     */
    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }
    public boolean saveEmployee(EmployeeData pEmployeeData) {
        EmployeeData existing = employeeData.get(pEmployeeData.getCode());
        if (existing == null) {
            pEmployeeData.setId(employeeData.size() + 1);
        }
        employeeData.put(pEmployeeData.getCode(), pEmployeeData);
        return true;
    }

    public EmployeeData getEmployee(String code) {
        return employeeData.get(code);
    }
}
