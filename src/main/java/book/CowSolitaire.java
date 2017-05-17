package book;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class CowSolitaire {
    public int count() {
        int n = 4;
        String[][] arr = new String[][] {{"8S", "AD", "3C", "AC"}, {"8C", "4H", "QD", "QS"}, {"5D", "9H", "KC", "7H"}, {"TC", "QC", "AS", "2D"}};
        String[] strQueue = new String[16];
        strQueue[0] = arr[3][0];
        int[][] tmp = new int[5][5];
        int[] intQueue = new int[16];
        intQueue[0] = tmp[3][0];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('T', 10);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i + 1][j + 1] = map.get(arr[i][j].charAt(0)) ;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int c = 1;
        int r = 4;
        //广度优先搜索
        int sum = 0;
//        Queue<Integer> queue = new LinkedBlockingQueue<Integer>(50);
//        queue.add(tmp[r][c]);
        System.out.print(arr[r - 1][c - 1] + " -> ");
//        System.out.print(tmp[r][c] + " -> ");
        sum += tmp[r][c];
        while (c != 4 && r != 1) {
            int a = tmp[r - 1][c];
            int b = tmp[r][c + 1];
            if (a >= b) {
                r--;
                System.out.print(arr[r - 1][c - 1] + " -> ");
//                System.out.print(tmp[r][c] + " -> ");
                sum += tmp[r][c];
            } else {
                c++;
                System.out.print(arr[r - 1][c - 1] + " -> ");
//                System.out.print(tmp[r][c] + " -> ");
                sum += tmp[r][c];
            }
        }
        System.out.println(arr[0][3]);
        sum += tmp[1][4];
        System.out.println("sum = " + sum);
        //动态规划，二维数组f[i][j]标识A[N][1] 到A[i][j]的大长度
        int[][] f = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            f[i][0] = 0;
        }
        for (int i = 0; i < n + 2; i++) {
            f[n + 1][i] = 0;
        }

        for (int i = n; i > 0; i--) {
            for (int j = 1; j < n + 1; j++) {
                int q = Math.max(f[i + 1][j], f[i][ j - 1]);
                f[i][j] = q + tmp[i][j];
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return 0;
    }

    public void recursionCont(int c, int r, int n, int[][] arr) {
        if ((c == n - 1) && (r == 0)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        } else {
            if (c < 3) {
                c++;
                arr[c][r] = arr[c][r] + arr[c - 1][r];
                recursionCont(c, r, n, arr);
            }
            if (r > 1) {
                r--;
                arr[c][r] = arr[c][r] + arr[c][r + 1];
                recursionCont(c, r, n, arr);
            }
        }
    }
}
