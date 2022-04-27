package practice.utils.datastruct.sort.bubble;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.function.Function;

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

    public int[] outer(int[] array) {
        if (ArrayUtils.isEmpty(array)) return new int[]{};

        int[] currentArray = array;
        for(int j = 0; j < array.length; j++) {
            currentArray = inner(currentArray);
            debug(currentArray);
        }

        return currentArray;
    }

    public int[] inner(int[] currentArray) {
        if (ArrayUtils.isEmpty(currentArray)) return new int[]{};

        int[] workTarget = new int[currentArray.length];
        for(int i = 0; i < workTarget.length; i++) {
            if (i == 0) {
                workTarget[i] = currentArray[i];
            } else if(workTarget[i-1] > currentArray[i]) {
                workTarget[i] = workTarget[i-1];
                workTarget[i-1] = currentArray[i];
            } else {
                workTarget[i] = currentArray[i];
            }
        }

        return workTarget;
    }

    public  int[] merge(Function<int[], int[]> outer, Function<int[], int[]> inner) {
        return new int[2];
    }

    public static void debug(int[] array) {
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("");
    }

}
