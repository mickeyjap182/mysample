package practice.basicfeature.ui.mainpane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenu {
    JFrame subTask;

    public JButton createBtn01(String btnName) {
        // ボタン作成
        JButton btn1 = new JButton(btnName);
        btn1.addActionListener(new ActionListener() {
            // クリック時の処理
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open new windows");
                subTask = new JFrame("TestWindow");
                subTask.setBounds( 100, 30, 100, 100);
                subTask.setVisible(true);
            }
        });
        return btn1;
    }
}
