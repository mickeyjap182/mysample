package practice.basicfeature.novice.designpetterns.solid.i.before;

public class User03 {
    public boolean execute() {
        var code = new OPS().op3();
        System.out.println(String.format("class: %s code: %s", getClass().toString(), code));
        return true;
    }
}
