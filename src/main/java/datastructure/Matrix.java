package datastructure;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class Matrix {
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[b[0].length][a.length];
        for (int i = 0;i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][k] = a[i][j] * b[k][i];
                }
            }
        }
        return c;
    }
}
