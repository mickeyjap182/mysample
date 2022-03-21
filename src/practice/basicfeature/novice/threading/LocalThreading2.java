package practice.basicfeature.novice.threading;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Locale;
import java.util.TimeZone;

class Int1 {
    // クラス変数(スレッド間で共有する値)の宣言
    private static int i;

    // getter
    public static int getInt() {
        return i;
    }
    // setter
    public static void setInt(int i) {
        Int1.i = i;
        System.out.println(String.format("it's value has changed to %d by Thread Name: %s", i, Thread.currentThread().getName()));
    }
}

class Int2 {
    // スレッドごとに独立した値のインスタンス
    private int i;

    // getter
    public int getInt() {
        return i;
    }
    // setter
    public void setInt(int i) {
        this.i = i;
        System.out.println(String.format("it's value has changed to %d by Thread Name: %s", i, Thread.currentThread().getName()));
    }
}

class NewInt {

    // 現行スレッドの初期値を取得...初期はnull
    private static ThreadLocal<Int2> tl = ThreadLocal.withInitial(Int2::new);

    //　現行スレッドの値を取得
    private static Int2 getNewInt(){
        return tl.get();
    }

    // 現行スレッドでのgetter
    public static int getInt(){
        return getNewInt().getInt();
    }

    // 現行スレッドでのsetter
    public static void setInt(int i){
        getNewInt().setInt(i);
    }

    // 現行スレッドでのterminator
    public static void remove(){
        tl.remove();
    }
}

class ThreadTest1 extends Thread {
    int val = 0;

    // コンストラクタ
    public ThreadTest1(int val){
        this.val = val;
    }
    // syynchronized で
    public void run() {
        for (int i = 0; i < 5; i++){

            // ThreadTestクラスのメンバ変数valの値を
            // Intクラスのクラス変数にセット
            // 各スレッドが共用しているクラス変数値を書き換えるため、エラー発生。
            Int1.setInt(val);

            // 1秒(1000ミリ秒)待機
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            // 処理結果の表示
            // valの値とIntクラスのクラス変数の値が異なる場合は異常でエラーを表示"
            int snapShotVal = Int1.getInt();
            String message = getName() + ": i = " + i + ", val = " + val + ", getVal = " + snapShotVal;
            if (val == snapShotVal) {
                System.out.println(message);
            } else {
                System.out.println(message + " エラー");
            }
        }
    }
}

class ThreadTest2 extends Thread {

    int val = 0;

    // コンストラクタ
    public ThreadTest2(int val){
        this.val = val;
    }

    public void run() {
        for (int i = 0; i < 5; i++){

            // ThreadTestクラスのメンバ変数valの値を
            // Intクラスのインスタンス変数にセット
            // 各スレッド別に紐付けたインスタンス変数を利用するため独立した操作となる。
            NewInt.setInt(val);

            // 1秒(1000ミリ秒)待機
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }

            // 処理結果の表示
            // valの値とIntクラスのクラス変数の値が異なる場合は異常でエラーを表示"
            int snapshotVal = NewInt.getInt();
            String message = getName() + ": i = " + i + ",val = " + val + ", getVal = " + snapshotVal;
            if (val == NewInt.getInt()) {
                System.out.println(message);
            } else {
                System.out.println(message + " エラー");
            }
            NewInt.remove();
        }
    }
}


public class LocalThreading2 {

    public static void main(String[] args) {
        // 変更前
        ThreadTest1 tt1 = new ThreadTest1(0);
        tt1.setName("aaa");
        ThreadTest1 tt2 = new ThreadTest1(1);
        tt2.setName("bbb");
        ThreadTest1 tt3 = new ThreadTest1(2);
        tt3.setName("ccc");
        FastDateFormat.getDateTimeInstance(1, 2, TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);
//        new CalendarDate(new LocalDateTime());

        // 変更後
        ThreadTest2 tt2_1 = new ThreadTest2(0);
        tt2_1.setName("new-aaa");
        ThreadTest2 tt2_2 = new ThreadTest2(1);
        tt2_2.setName("new-bbb");
        ThreadTest2 tt2_3 = new ThreadTest2(2);
        tt2_3.setName("new-ccc");

        System.out.println("====before fixed it.====");
        Thread[] threads1 = new Thread[]{tt1, tt2, tt3};
        run(threads1);
        mergeMain(threads1);
        System.out.println("====after fixed it.====");
        Thread[] threads2 = new Thread[]{tt2_1, tt2_2, tt2_3};
        run(threads2);


    }

    public static void run(Thread[] threads) {
        for(Thread th : threads) {
            th.start();
            try {
                Thread.sleep(3000);
            } catch (IllegalThreadStateException e) {
                throw e;
            } catch (InterruptedException e) {
                // unsafe thread error.
                e.printStackTrace();
            }
        }
    }
    public static void mergeMain(Thread[] threads) {
        for(Thread th : threads) {
            try {
                th.join();

            } catch (InterruptedException e) { }
        }
    }
}