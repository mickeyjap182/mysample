package practice.basicfeature.novice.designpetterns.feature.adapter;

public interface Claimable {
    // 請求する。
    public void claim(long amount);

    // 受領する。
    public void receipt();

    // 額面取得
    public long getAmount();

    public boolean isClaimed();

    public boolean isReceipted();
}
