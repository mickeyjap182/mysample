package practice.basicfeature.novice.designpetterns.solid.i.before;

public class User01 {

    public boolean execute() {
        var code = new OPS().op1();
        System.out.println(String.format("class: %s code: %s", getClass().toString(), code));
        return true;
    }
}
