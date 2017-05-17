package book;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class BagBack {
    public void solution(int[] w, int[] v, int c) {
        int r = w.length + 1;
//        int[] a =
        int[][] m = new int[r][c + 1];
        for (int i = 0; i < m.length; i++) {
            m[i][0] = 0;
        }
        for (int j = 0; j < c + 1; j++) {
            m[0][j] = 0;
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(v[i - 1] + m[i - 1][j - w[i - 1]], m[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < c + 1; j++){
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
