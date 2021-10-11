package practice.basicfeature.novice.extendsinterface.abstruct;

public enum ANIMAL_TYPE {
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
