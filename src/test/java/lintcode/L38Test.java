package lintcode;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-02 14:09
 */
public class L38Test {
    @Test
    public void searchMatrix() throws Exception {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
        System.out.println(new L38().searchMatrix(matrix, 9));
    }

}