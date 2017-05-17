package book;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class CommonLongestSubsequence {
    public void lcsLength(String[] x, String[] y) {
        int m = x.length + 1;
        int n = y.length + 1;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < n; j++ ) {
            c[0][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i - 1].compareTo(y[j - 1]) == 0) {
                    System.out.println(i - 1);
                    System.out.println(x[i - 1]);
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    if (c[i - 1][j] > c[i][j - 1]) {
                        c[i][j] = c[i - 1][j];
                    } else {
                        c[i][j] = c[i][j - 1];
                    }
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        printLCS(c, x, y, m - 1, n - 1 );

    }

    public void printLCS(int[][] c, String[] x, String[] y, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (x[i - 1] == y[j - 1]) {
            printLCS(c, x, y, i - 1, j - 1);
            System.out.print(x[i - 1] + " ");
        } else {
            if (c[i - 1][j] > c[i][j - 1]) {
                printLCS(c, x, y, i - 1, j);
            } else {
                printLCS(c, x, y, i, j - 1);
            }
        }
    }
}
