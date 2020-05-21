package practice.basicfeature.novice.extendsinterface.interfaces;

public interface Myif {

    /** function */
    static String getItem(String key) {
        switch(key) {
            case "dog":
                return "Woh";

            case "cat":
                return "Miu";

            case "fox":
                return "Wooo";
            default:
                return "Ooops!";

        }

    }

    public void bark(String voice);
    public void sleep();
}
