package practice.basicfeature.ui;

import org.apache.commons.collections4.CollectionUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileLockInterruptionException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
// formstackツール
// 無料体験フォーム
// 代理店
// WEB直
public class Gui extends JFrame implements ActionListener, WindowListener {
    private static final String lockFile = ".lockfile.lock";
    private static final long serialVersionUID = 1L;
    private List<String> messages = new ArrayList<>();

    JFrame subTask;

    // ウィンドウ本体
    public Gui() {
        lock(lockFile);

        // メインウィンドウの閉じ方
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 位置とサイズ
        setTitle("メインペーン");
        setBounds(100, 100, 640, 480);
        // メインウィンドウのイベント設定
        addWindowListener(this);

        // セレクトボックス
        JComboBox combo = new JComboBox();
        combo.addItem("test1");
        combo.addItem("test2");
        JPanel select = new JPanel();
        select.add(combo);
//        getContentPane().add(select, BorderLayout.CENTER);
        add(select);

        // ボタン作成
        JButton btn1 = new JButton("Click Me");
        add(btn1);  // ボタン追加
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

    }

    public static void main(String[] args) {
        Gui frm = new Gui();   // ウィンドウ作成
        // 初期チェック
        if (CollectionUtils.isNotEmpty(frm.getMessage())) {
            // alertして終了
            return;
        }
        frm.setVisible(true);  // 表示
        System.out.println(getFrames().length);
    }

    public List<String> getMessage() {
        return messages;
    }

    private boolean isLock(FileLock lock) {
        return lock == null;
    }

    private void lock(String filePath) {
        try (FileOutputStream stream = new FileOutputStream(filePath)) {
            FileChannel channel = stream.getChannel();
            FileLock fl = channel.tryLock();
            if (isLock(fl)) {
                throw new FileLockInterruptionException();
            }

        } catch (Exception e) {
            e.printStackTrace();
            messages.add(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("open main window");
//        subTask = new JFrame("TestWindow");
//        subTask.setBounds( 100, 30, 100, 100);
//        subTask.setVisible(false);
//        subTask.addWindowListener(this);
//        subTask.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.print("opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.print("exiting");

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.print("closed");

        Path p = Paths.get(lockFile);

        try {
            Files.delete(p);
        }catch(IOException ex){
            ex.printStackTrace();
            messages.add(ex.getMessage());
        }

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
