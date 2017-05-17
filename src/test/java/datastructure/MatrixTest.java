package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class MatrixTest {
    @Test
    public void multiply() throws Exception {
        int[][] a = new int[][] {{1, 1, 1}, {2, 2, 2,}, {3, 3, 3}, {4, 4, 4}};
        int[][] b = new int[][] {{1, 1, 1, 1,}, {2, 2, 2, 2}, {3, 3, 3, 3}};
        Matrix matrix = new Matrix();
        int[][] c =  matrix.multiply(a, b);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

}