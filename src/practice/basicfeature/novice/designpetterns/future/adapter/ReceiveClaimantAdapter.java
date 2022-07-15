package practice.basicfeature.novice.designpetterns.future.adapter;

public class ReceiveClaimantAdapter implements Receiver {

    private Claimable claimable;
    public ReceiveClaimantAdapter(Claimable claimable) {
        this.claimable = claimable;
    }
    @Override
    public void apply(long amount) {
        claimable.claim(amount);
    }

    @Override
    public void receive() {
        claimable.receipt();
    }
    @Override
    public long getAmount() {
        return claimable.isReceipted()
                ? claimable.getAmount()
                // 未受領であれば未入金で0円
                : 0;
    }
}
