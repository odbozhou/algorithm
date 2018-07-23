package lintcode;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-02 17:50
 */
public class L80Test {
    @Test
    public void median() throws Exception {
        int[] a = new int[]{4, 5, 1, 2, 3};
        L80 l80 = new L80();
        System.out.println(l80.median(a));
    }

    @Test
    public void bubbleSort() throws Exception {
        int[] a = new int[]{9, 5, 8, 1, 2, 4};
        L80 l80 = new L80();
        l80.selectSort(a);
    }

}