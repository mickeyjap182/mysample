package practice.basicfeature.novice.extendsinterface;

public class Dog {
    private String name;
    public Dog(String name) {
        this.name = name;
    }
    public void bark(String voice) {
        System.out.println(voice);

    }
    public void sleep() {
        System.out.println("Percian is sleeping");
    }
}
