package practice.basicfeature.novice.syntax;


public class TempDrive {

    public static void main(String[] args) {
        TempDrive mySelf = new TempDrive();
        // autoboxing about out of 1byte(-127 ... 127)
        mySelf.AutoBoxingBugs();

    }

    public void AutoBoxingBugs() {
        Integer a1 = 127;
        Integer a2 = 127;

        Integer b1 = 128;
        Integer b2 = 128;

        System.out.printf(" a1 == a2: %b %n", a1 == a2);
        System.out.printf(" a1.equals(a2): %b %n", a1.equals(a2));
        System.out.printf(" a1 == a2.intValue(): %b %n", a1 == a2.intValue());

        System.out.printf(" CAUSION: b1 == b2: %b %n", b1 == b2);
        System.out.printf(" b1.equals(b2): %b %n", b1.equals(b2));
        System.out.printf(" b1 == b2.intValue(): %b %n", b1 == b2.intValue());
        System.out.printf(" b1.intValue() == b2: %b %n", b1.intValue() == b2);

    }

}
