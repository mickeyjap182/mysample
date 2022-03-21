package practice.utils.datastruct.sort.bubble;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * bubblesort
 */
final public class IntSort {

    public IntSort() {

    }
    public int[] sort(int[] array) {
        if (ArrayUtils.isEmpty(array)) return new int[]{};

        int[] sorted;
        int[] tmpSorted;
        sorted = array;
        for(int j = 0; j < array.length; j++) {
            tmpSorted = new int[array.length];
            for(int i = 0; i < array.length; i++) {
                if (i == 0 ) {
                    tmpSorted[i] = sorted[i];
                } else if(tmpSorted[i-1] > sorted[i]) {
                    tmpSorted[i] = tmpSorted[i-1];
                    tmpSorted[i-1] = sorted[i];
                } else {
                    tmpSorted[i] = sorted[i];
                }
            }
            sorted = tmpSorted;
//            debug(sorted);
        }

        return sorted;
    }

    public static void debug(int[] array) {
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("");
    }

}
