package practice.basicfeature.novice.designpetterns.solid.s.before;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] list = new String[]{"A","B","C","D","E"};
//        String[] list = null; // -> NPE.
        var id = Arrays.stream(list).map(v -> {
            String ret;
            switch(v) {
                case "D":
                    ret = v + " is great!";
                    break;
                case "C":
                    ret = v + " is good!";
                    break;
                default:
                    ret = null;
            }
            return ret;
        }).filter(Objects::nonNull)
                .findFirst();
        System.out.println(id.orElse("NOTHING!"));

        List<String> list2 = Collections.emptyList();
        var id2 = list2.stream().map(v -> {
            String ret;
            switch(v) {
                case "D":
                    ret = v + " is great!";
                    break;
                case "C":
                    ret = v + " is good!";
                    break;
                default:
                    ret = null;
            }
            return ret;
        }).filter(Objects::nonNull)
                .findFirst();

        try {
            String s2 = null;
            System.out.println(id2.orElse("NOTHING2!"));
            System.out.println(s2);
        } catch(Exception e) {
            e.printStackTrace();
        }

//        Integer a2 = Integer.valueOf(s2); // エラーになる。
        var debug =  new DebugLogger();

        Map<Pattern, Object> testPatterns = new LinkedHashMap<>();
        testPatterns.put(new Pattern(1,"001","数値のプリミティブへのキャスト") ,Integer.valueOf(10));
        testPatterns.put(new Pattern(2,"002","null値のキャスト") , null);
        testPatterns.put(new Pattern(3,"003","範囲外のキャスト") ,Integer.MAX_VALUE);

        doEach(testPatterns, debug);
    }
    private static int toPrim(Integer i) {
        return i.intValue();
    }
    public static void doEach(Map<Pattern, Object> patterns, DebugLogger debugLogger) {

        for(Map.Entry<Pattern, Object> pattern: patterns.entrySet()) {
            Pattern target = pattern.getKey();
            debugLogger.logging(System.out, DebugLogger.IOResource.CONSOLE, target);
            try {
                switch (target.id) {
                    case 1:
                    case 2:
                        int p = toPrim((Integer)pattern.getValue());
                        System.out.println(p);
                        break;
                    case 3:
                        Integer v = Integer.valueOf((Integer)pattern.getValue());
                        Long t = Long.valueOf(v.longValue());
                        Long r = 1L + t;
                        System.out.println(r);
                        break;

                    default:
                        break;

                }

            } catch(Exception e) {
                System.out.println(String.format("Error: pattern: %d - %s  value:", target.id, target.detail, pattern.getValue() == null ? "null" : pattern.getValue() ));
            }
        }

    }

    public static class Pattern {
        int id;
        String code;
        String detail;
        public Pattern(int id, String code, String detail) {
            this.id = id;
            this.code = code;
            this.detail = detail;
        }
    }

    public static class DebugLogger {
        enum IOResource {
            FILE,
            CONSOLE;
        }
        private static final String FORMAT = "==== phase: %d  contents:%s ====";
        private int index;
        private String message;
        public DebugLogger() {
            index = 0;
            message = "started";
        }
        public void addPhase(String message) {
            this.message = message;
        }
        public void next(String message) {
            addPhase(message);
            index++;
        }

        public boolean logging(OutputStream o, IOResource resource, Pattern pattern) {
            index = pattern.id;
            message = pattern.detail;
            return logging(o, resource);
        }
        public boolean logging(OutputStream o, IOResource resource) {
            String message = String.format(FORMAT, index, this.message);
            switch (resource) {
                case CONSOLE:
                    ((PrintStream)o).println(message);

                case FILE:
                default:
                    break;
            }
            return true;
        }

        public int getPattern() {
            return index;
        }
    }
}
