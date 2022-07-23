package practice.basicfeature.novice.designpetterns.feature.observer;

import java.awt.image.TileObserver;

public interface Observer extends TileObserver {
    /** 購読情報の状態変更通知を受け取る */
    void update();
}
