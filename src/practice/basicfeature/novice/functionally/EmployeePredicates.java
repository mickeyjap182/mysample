package practice.basicfeature.novice.functionally;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates
{
    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    public static List<Employee> filterEmployees (List<Employee> employees,
                                                  Predicate<Employee> predicate)
    {
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Employee>toList());
    }
//    public boolean isSame(Employee emp, Employee emp2) {
//        System.out.println(String.format("This is Predicate.isEqual(emp2): %b ", Predicate.isEqual(emp2)));
//        return true;
//        return p -> p.getAge().equals(target.getAge()) &&
//                p.getGender().equals(target.getGender());
//
//    }
}