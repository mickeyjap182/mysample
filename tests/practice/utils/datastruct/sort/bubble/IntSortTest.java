package practice.utils.datastruct.sort.bubble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class IntSortTest {
    @Test
    public void sortasc() {
        int[] array = new int[]{9, 5, 4 ,2 ,6, 3, 7, 8 ,1};
        IntSort base = new IntSort();
        int[] ret = base.sort(array);
        int[] expected =  new int[]{1, 2, 3 ,4 ,5, 6, 7, 8 ,9};
        assertTrue(Arrays.equals(ret, expected));

        int[] ret2 = base.outer(array);
        assertTrue(Arrays.equals(ret2, expected));
        // 回す
        final List<Integer> tmp = new ArrayList<>();
//        tmp.a
//        Function<int[], int[]> i1 = Arrays.stream(array)
//                .reduce((prev, current) -> {
//                    int value = current < prev ? prev: current;
//                    tmp.add(value);
//                });
    }

}