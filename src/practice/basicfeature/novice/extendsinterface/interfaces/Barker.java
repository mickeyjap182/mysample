package practice.basicfeature.novice.extendsinterface.interfaces;

 public interface Barker {

    enum ANIMAL_TYPE {
        DOG(1, "dog"),
        CAT(2, "cat");

        public int id;
        public String type;
        ANIMAL_TYPE(int id, String type) {
            this.id = id;
            this.type = type;
        }
        public String getType(ANIMAL_TYPE name) {
            return ANIMAL_TYPE.valueOf(name.toString()).type;
        }
        public int getId(ANIMAL_TYPE name) {
            return ANIMAL_TYPE.valueOf(name.toString()).id;
        }
    }

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
