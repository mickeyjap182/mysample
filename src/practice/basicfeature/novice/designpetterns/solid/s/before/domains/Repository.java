package practice.basicfeature.novice.designpetterns.solid.s.before.domains;

import java.util.concurrent.ConcurrentHashMap;

public class Repository {
    private static Repository repository;
    ConcurrentHashMap<String, Employee> employee;
    private Repository(){
        employee = new ConcurrentHashMap<>();
    }
    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }
    public boolean saveEmployee(Employee pEmployee) {
         Employee existing = employee.get(pEmployee.getCode());
         if (existing == null) {
            pEmployee.setId(employee.size() + 1);
         }
         employee.put(pEmployee.getCode(), pEmployee);
         return true;
    }

    public Employee getEmployee(String code) {
        return employee.get(code);
    }
}
