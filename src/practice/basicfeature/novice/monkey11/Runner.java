package practice.basicfeature.novice.monkey11;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Runner {

    private static final Pattern PATTERN_NUM = Pattern.compile("[0123456789]");
    private static final Pattern PATTERN_LOWER_CASE = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
    private static final Pattern PATTERN_UPPER_CASE = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]");
    private static final Pattern PATTERN_ETC = Pattern.compile("[^0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]");

    public static class OptionalWrapper {
        Optional<String> value;
        OptionalWrapper(String value){
            this.value = value == null ? Optional.empty() : Optional.of(value);
        }

        public Optional<String> getValue() {
            return this.value;
        }
    }

    public void main(String[] args) {

        System.out.println("====Java11====");

        final String chars = "";
        List<Pattern> complexityVarieties = List.of(PATTERN_NUM, PATTERN_UPPER_CASE, PATTERN_LOWER_CASE, PATTERN_ETC);
        int complexity = complexityVarieties.stream()
                .filter(variety -> variety.matcher(chars).find())
                .reduce(0, (sum, variety) -> sum + 1, Integer::sum);

        System.out.println("=====level:==="+Integer.valueOf(complexity)+"====");
        Optional<OptionalWrapper> aaa = Optional.of(new OptionalWrapper("a"));

        Optional<OptionalWrapper> no =  Optional.empty();

        Optional<OptionalWrapper> in_no =  Optional.of(new OptionalWrapper(null));

        Optional<String> ret =  aaa.flatMap(v -> {
            Optional val = v.getValue();
            System.out.println("==do aaa check.==");
            return val.isEmpty() ? Optional.empty() : Optional.of("answer:" + val.get().toString()).map(String::toUpperCase);
        });
        System.out.println(ret);
        ret =  in_no.flatMap(v -> {
            Optional val = v.getValue();
            System.out.println("==do in_no check.==");
            return val.isEmpty() ? Optional.empty() : Optional.of("answer:" + val.get().toString()).map(String::toUpperCase);
        });
        System.out.println(no);
        ret =  no.flatMap(v -> {
            Optional val = v.getValue();
            System.out.println("==do no check.==");
            return val.isEmpty() ? Optional.empty() : Optional.of("answer:" + val.get().toString()).map(String::toUpperCase);
        });
        System.out.println(ret);

        var();

        privateif();

        try {
            tryWithResource();
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

    private void tryWithResource() throws IOException{
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
