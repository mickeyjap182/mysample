package practice.basicfeature.ui;

import practice.basicfeature.ui.mainpane.SelectAction;
import practice.basicfeature.ui.mainpane.SubMenu;

import javax.swing.*;
import java.awt.*;
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


    // ウィンドウ本体
    public Gui() {
        lock(lockFile);

        // メインウィンドウの閉じ方
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
//        setLayout(new GridLayout(1,2));
        // 位置とサイズ
        setTitle("書籍検索");
        setBounds(100, 100, 640, 480);
        // メインウィンドウのイベント設定
        addWindowListener(this);

        // セレクトボックス
        JPanel select = new JPanel(new BorderLayout());
        var genre = new Label("ジャンル");
        select.add(genre, BorderLayout.NORTH);
        JComboBox combo = new JComboBox();
        combo.addActionListener(new SelectAction());
        combo.addItem("test1");
        combo.addItem("test2");
        select.add(combo, BorderLayout.SOUTH);
        add(select);

        // ボタン作成
        var sub = new SubMenu();
        JButton btn1 = sub.createBtn01("一覧検索");
        var createbtn = new JPanel(new GridLayout(2,3));
        createbtn.setPreferredSize(new Dimension(300,100));
        createbtn.setBackground(Color.BLUE);
        createbtn.add(btn1);
        createbtn.add(new JLabel(" "));
        createbtn.add(new JLabel(" "));
        createbtn.add(sub.createBtn01("Click Me2"));
        createbtn.add(new JLabel(" "));
        createbtn.add(new JLabel(" "));
        add(createbtn);  // ボタン追加

    }


    public static Frame[] getFrames() {
        return JFrame.getFrames();
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
