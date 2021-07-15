package practice.basicfeature.novice.syntax;

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
}
