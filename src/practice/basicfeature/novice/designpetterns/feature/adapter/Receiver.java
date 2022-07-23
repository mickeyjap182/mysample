package practice.basicfeature.novice.designpetterns.feature.adapter;

public interface Receiver {
    // 申請する
    public void apply(long amount);

    // 受給する
    public void receive();

    // 額面取得
    public long getAmount();
}
