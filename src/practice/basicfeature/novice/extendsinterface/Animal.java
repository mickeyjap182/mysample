package practice.basicfeature.novice.extendsinterface;

import practice.basicfeature.novice.extendsinterface.interfaces.Myif;

public class Animal {
    public class Shiba implements Myif {

        public void bark(String voice) {
            System.out.println(voice);

        }
        public void sleep() {
            System.out.println("Shiba is sleeping");
        }

    }
    public class Percian implements Myif {

        public void bark(String voice) {
            System.out.println(voice);

        }
        public void sleep() {
            System.out.println("Percian is sleeping");
        }

    }
}
