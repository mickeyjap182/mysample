package practice.basicfeature.novice.designpetterns.feature.adapter;

public class Claimant implements Claimable {

    private boolean claimed = false;
    private boolean receipted = false;
    private long amount = 0;

    @Override
    public void claim(long amount) {
        claimed = true;
        this.amount = amount;
    }

    @Override
    public void receipt() {
        receipted = true;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public boolean isReceipted() {
        return receipted;
    }
    static boolean isOdd(int a) {
        return (a != 0 && a % 2 == 1);
    }
}
