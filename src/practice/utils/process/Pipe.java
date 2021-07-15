package practice.utils.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pipe {
    public enum Status {
        START(0),
        SUSPEND(1),
        RESUME(2),
        STOP(3),
        FINISH(4),
        DESTROY(9);

        public int statusCd;
        Status(int statusCd){
            this.statusCd = statusCd;
        }

        public int code() {
            return this.statusCd;
        }
    }

    public String tmp(String command) {

        String ret = (true && false || false) ? "true" : "false";
        System.out.println(String.format("(true && false || false) is : %s", ret));

        ret = (true || false && false) ? "true" : "false";
        System.out.println(String.format("(true || false && false) is : %s", ret));

        ret = (false && true || false) ? "true" : "false";
        System.out.println(String.format("(false && true || false) is : %s", ret));

        ret = (false || true && false) ? "true" : "false";
        System.out.println(String.format("(false || true && false) is : %s", ret));

        ret = (false && false || true) ? "true" : "false";
        System.out.println(String.format("(false && false || true) is : %s", ret));

        ret = (false || false && true) ? "true" : "false";
        System.out.println(String.format("(false || false && true) is : %s", ret));

        ret = (false && false || false) ? "true" : "false";
        System.out.println(String.format("(false && false || false)  is : %s", ret));

        ret = (false || false && false) ? "true" : "false";
        System.out.println(String.format("(false || false && false)  is : %s", ret));

        ret = (true && true || false) ? "true" : "false";
        System.out.println(String.format("(true && true || false)  is : %s", ret));

        ret = (true || true && false) ? "true" : "false";
        System.out.println(String.format("(true || true && false)  is : %s", ret));

        return "1";

    }
    public String sendCommand(String command) {

        List<String> textList = new ArrayList<>();
        try {
            String[] cmdarray = {command};
            Process process = Runtime.getRuntime().exec(cmdarray);
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                textList.add(line);
            }
            process.waitFor();
            process.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "failed command exec";
        }
        return textList.stream().collect(Collectors.joining());
    }
}
