package practice.basicfeature.novice.syntax;

public class MoneyPod {
    private int amount;

    /**
     * @TODO if amount parameter change 'Integer' to 'int', NoSuchMethodException occured at getDeclaredConstructor();
     * @param amount
     */
    public MoneyPod(Integer amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
