package practice.basicfeature;

import org.apache.commons.collections4.CollectionUtils;
import practice.basicfeature.ui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui frm = new Gui();   // ウィンドウ作成
        // 初期チェック
        if (CollectionUtils.isNotEmpty(frm.getMessage())) {
            // alertして終了
            return;
        }
        frm.setVisible(true);  // 表示
        System.out.println(Gui.getFrames().length);
    }
}