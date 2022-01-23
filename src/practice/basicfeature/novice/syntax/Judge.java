package practice.basicfeature.novice.syntax;

public class Judge {
    public boolean execute() {
        boolean a1 = false;boolean b1 = true;boolean c1 = true;
        System.out.println(a1 || b1 && c1);
        boolean a2 = true;boolean b2 = true;boolean c2 = false;
        System.out.println(a2 || b2 && c2);
        boolean a3 = false;boolean b3 = true;boolean c3 = false;
        System.out.println(a3 || b3 && c3);

        return true;
    }
}
