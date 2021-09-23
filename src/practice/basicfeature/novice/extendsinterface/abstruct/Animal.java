package practice.basicfeature.novice.extendsinterface.abstruct;

import practice.basicfeature.novice.extendsinterface.interfaces.Barker;

public class Animal {
    public static class Shiba implements Barker {

        public void bark(String voice) {
            System.out.println(voice);

        }
        public void sleep() {
            System.out.println("Shiba is sleeping");
        }

    }
    public class Percian implements Barker {

        public void bark(String voice) {
            System.out.println(voice);

        }
        public void sleep() {
            System.out.println("Percian is sleeping");
        }

    }
}
