package practice.basicfeature.novice.monkey11;

import practice.basicfeature.novice.threading.Multi;

import java.io.*;
import java.util.List;

public class Runner {

    public void main(String[] args) {

        System.out.println("====Java11====");

        var();

        privateif();

        try {
            trywithrewource();
        } catch(IOException e) {
            System.out.println("failed to open file: " +e.getMessage());
        }
    }

    private void var() {

        System.out.println("====var variable====");
        var fluits = List.of("Banana", "Orange", "StrawBerry");
        // if you use primitive wrapper class  or nullable class, you should not use "var".
        Integer len = fluits.size();
        System.out.println(len);
    }

    private void privateif() {

        System.out.println("====vprivate interface method ====");
        new Monkey().initialize();
    }

    private void trywithrewource() throws IOException{
        // as final variable .
        var root = new File("").getAbsolutePath();
        System.out.println("=== file: " + root + "===");
        var reader = new InputStreamReader(new FileInputStream(root + "/src/practice/basicfeature/novice/monkey11/monkey.txt"), "utf-8");
        try (reader) {
            var buf  = new BufferedReader(reader);
            String line = buf.readLine();
            while (line != null) {
                System.out.println(line);
                line = buf.readLine();
            }

            System.out.println("=== try  end===");
        } catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("=== catch end===");


        } finally {
            // it is possible to use try-with-resource in finally block.
            if (reader == null ) {
                System.out.println("=== final reader is null ===");
            } else {
                System.out.println("=== final reader is not null ===");
            }


        }

    }

}
