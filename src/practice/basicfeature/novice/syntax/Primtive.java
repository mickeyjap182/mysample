package practice.basicfeature.novice.syntax;

import practice.utils.logger.DebugLogger;
import practice.utils.logger.Pattern;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primtive {

    public static final int DEF_INT_256 = 256;
    public static final int DEF_INT_255 = 255;
    public static final Integer DEF_INTEGER_256 = 256;
    public static final Integer DEF_INTEGER_255 = 255;

    public static void main(String[] args) {

        Primtive mySelf = new Primtive();
        // https://stackoverflow.com/questions/32206092/java8-method-reference-used-as-function-object-to-combine-functions

        Integer localInteger = 100;

        System.out.println(String.format("1. (Integer 100 == int 100): %b",(Boolean) (DEF_INT_255 == localInteger)));
        System.out.println(String.format("2. (Integer 100.equals( int 100)): %b",(Boolean) (DEF_INTEGER_255.equals(DEF_INT_255))));

        localInteger = 256;
        System.out.println(String.format("3. (Integer 100 == int 256): %b",(Boolean) (DEF_INTEGER_255 == DEF_INT_255)));
        System.out.println(String.format("4. (Integer 100 == int 100): %b",(Boolean) (DEF_INTEGER_255.equals(DEF_INT_255))));

        localInteger = 256;
        IntStream rangeStream = IntStream.range(1, 10);
        Stream boxedStream = rangeStream.boxed();
//        List<Integer> rangeList = boxedStream.collect(Collectors.toList());


//        System.out.println(String.format("3. (Integer 100 == int 256): %b",sum(rangeList, 3));
        System.out.println(String.format("4. (Integer 100 == int 100): %b",(Boolean) (DEF_INTEGER_255.equals(DEF_INT_255))));

        System.out.println(mySelf.caseIncludeSame(1));
        System.out.println(mySelf.caseIncludeSame(2));
        System.out.println(mySelf.caseIncludeSame(3));
        System.out.println(mySelf.caseIncludeSame2(1));
        System.out.println(mySelf.caseIncludeSame2(2));
        System.out.println(mySelf.caseIncludeSame2(3));

        // メソッド変数の比較 オートボクシングミス
        if (mySelf.getIntFromInteger(DEF_INTEGER_256) == DEF_INT_256) {
            System.out.printf(" good ID:%d == %d \n", mySelf.getIntFromInteger(DEF_INTEGER_256), DEF_INT_256);
        } else {
            System.out.printf(" bad ID:%d == %d \n", mySelf.getIntFromInteger(DEF_INTEGER_256), DEF_INT_256);
        }

        // 定数の比較
        if (DEF_INT_256 == DEF_INTEGER_256) {
            System.out.printf(" good ID:%d\n", DEF_INTEGER_256);
        } else {
            System.out.printf(" bad ID:%d\n", DEF_INTEGER_256);
        }

    }

    public Integer getIntegerFromInt(int value) {
        return value;
    }
    public int getIntFromInteger(Integer value) {
        return Integer.valueOf(value);
    }

    public String caseIncludeSame(int num) {
        switch (num) {
            case 1 : return "1 or 2";
            case 2 : return "1 or 2";
            default : return "others";
        }
    }

    public String caseIncludeSame2(int num) {
        switch (num) {
            case 1 :
            case 2 : return "1 or 2";
            default : return "others";
        }

    }
    public void cast(String[] args) {


        String[] list = new String[]{"A","B","C","D","E"};
        String[] list3 = new String[]{null,null,null,null,null};
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

        Arrays.stream(list)
                .flatMap(x -> Stream.of(x, x+ "0", x+ "01"))
                .forEach(System.out::println);

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

        Optional<String> a  = Arrays.stream(list3).filter(v -> !Objects.isNull(v)).findFirst();
        String answer = a.isEmpty() ? "empty" : a.get();
        System.out.println(answer);
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
            var target = pattern.getKey();
            debugLogger.logging(System.out, DebugLogger.IOResource.CONSOLE, target);
            try {
                switch (target.getId()) {
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
                System.out.println(String.format("Error: pattern: %d - %s  value:", target.getId(), target.getDetail(), pattern.getValue() == null ? "null" : pattern.getValue() ));
            }
        }
    }

}
