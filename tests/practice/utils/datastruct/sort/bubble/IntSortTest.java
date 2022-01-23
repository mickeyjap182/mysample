package practice.utils.datastruct.sort.bubble;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class IntSortTest {
    @Test
    public void sortasc() {
        int[] array = new int[]{9, 5, 4 ,2 ,6, 3, 7, 8 ,1};
        IntSort base = new IntSort();
        int[] ret = base.sort(array);
        int[] expected =  new int[]{1, 2, 3 ,4 ,5, 6, 7, 8 ,9};
        assertTrue(Arrays.equals(ret, expected));
    }

}