package datastructure.sort;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-06 19:55
 */
public class QuickSortTest {
    @Test
    public void quickSort() throws Exception {
//        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] a = new int[]{8, 5, 9, 1, 3, 2, 0};
        new QuickSort().quickSort(a, 1, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}