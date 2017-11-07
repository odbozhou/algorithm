package datastructure.sort;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-07 10:56
 */
public class BubbleSortTest {
    @Test
    public void sort() throws Exception {
//        int[] a = new int[] {3, 5, 1, 9, 7, 6};
        int[] a = new int[]{1, 2, 9, 4, 5, 6};
        new BubbleSort().sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}