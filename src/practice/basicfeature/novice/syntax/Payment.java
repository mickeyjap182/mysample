package practice.basicfeature.novice.syntax;

public enum Payment {

    CREDIT(1),
    ELECTRIC(2);

    private final int type;

    private Payment(int type) {
        this.type = type;
    }

    public int getValue() {
        return this.type;
    }
}
