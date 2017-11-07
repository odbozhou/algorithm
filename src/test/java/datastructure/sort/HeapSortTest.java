package datastructure.sort;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-07 15:44
 */
public class HeapSortTest {
    @Test
    public void heapSort() throws Exception {
        int[] a = new int[]{1, 2, 9, 4, 5, 6};
        new HeapSort().heapSort(a);
    }

}