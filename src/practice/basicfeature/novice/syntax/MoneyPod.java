package practice.basicfeature.novice.syntax;

public class MoneyPod {
    private int amount;

    /**
     * @TODO if amount parameter change 'Integer' to 'int', NoSuchMethodException occured at getDeclaredConstructor();
     */
    public MoneyPod() {
        amount = 0;
    }

    /**
     * get total amount.
     *
     * @return total amount.
     */
    public int getAmount(int pickupAmount) {
        if (this.amount < pickupAmount ) {
            throw new MoneyPodOverflowException(String.format("==Too large Pick up Value: %s , and left is ==="));
        }
        return amount;
    }

    /**
     * @param amount  as addtional
     */
    public void addAmount(int amount) {
        //
        if ((Integer.MAX_VALUE - this.amount) <= amount ) {
            throw new MoneyPodOverflowException("==Too large Value!===");
        }
        this.amount += amount;
    }
}
