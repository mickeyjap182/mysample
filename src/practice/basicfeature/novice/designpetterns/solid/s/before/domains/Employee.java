package practice.basicfeature.novice.designpetterns.solid.s.before.domains;

public class Employee {
    public void calcuratePay() {
        int unitprice = 1500;
        int times = regularHours(3, 8);
        System.out.println(String.format("workingtime: %d",unitprice * times));

    }
    public void reportHours() {
        int times = regularHours(3, 8);
        System.out.println(String.format("workingtime: %d", times));
    }
    public void save() {

    }
    private int regularHours(int days, int hoursPerday) {
        return days * hoursPerday;
    }
}
