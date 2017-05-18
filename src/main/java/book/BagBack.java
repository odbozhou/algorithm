package book;

import java.util.Scanner;

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
            for (int j = 0; j < c + 1; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("bagback: ");
        printBagback(w, v, m, r - 1, c);

        int[] x = bulidSolution(m, w, c);
        for (int n : x) {
            System.out.print(n + " ");
        }


    }

    //这个好像也没啥问题
    private void printBagback(int[] w, int[] v, int[][] m, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        } else {
            if (w[i - 1] > j) {
                printBagback(w, v, m, i - 1, j);
            } else {
                if (m[i - 1][j - w[i - 1]] + v[i - 1] >= m[i - 1][j]) {
                    printBagback(w, v, m, i - 1, j - w[i - 1]);
                    System.out.print(i - 1 + ":" + w[i - 1] + " ");
                    System.out.println(i - 1 + ":" + v[i - 1] + " ");
                } else {
                    printBagback(w, v, m, i - 1, j);
                }
            }
        }
    }

    //这个求的是所有价值（vi）之和最大
    private int[] bulidSolution(int[][] m, int[] w, int c) {
        int n = w.length;
        int[] x = new int[n];
        int j = c;
        for (int i = n; i > 0; i--) {
            if (m[i][j] == m[i - 1][j]) {
                x[i - 1] = 0;
            } else {
                x[i - 1] = 1;
                j -= w[i - 1];
            }
        }
        return x;
    }

    public void ciceroneAbacus() {
    /*   Scanner scanner1 = new Scanner(System.in);
       int n = scanner1.nextInt();
       Scanner scanner2 = new Scanner(System.in);

       int[] budget = new int[n];
       int j = 0;
       while (j < 3) {
           budget[j] = scanner2.nextInt();
           j++;
       }
       Scanner scanner3 = new Scanner(System.in);
       int plan = scanner3.nextInt();
       int w[] = new int[plan];
       int v[] = new int[plan];
        Scanner scanner5;
        for (int i = 0; i < plan; i++) {
            scanner5 = new Scanner(System.in);
            w[i] = scanner5.nextInt();
            v[i] = scanner5.nextInt();
        }
        System.out.println();
        System.out.println(n);
        for (int i = 0; i < budget.length; i++) {
            System.out.print(budget[i] + " ");
        }
        System.out.println();
        System.out.println(n);
        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
*/
        int n = 3;
        int[] budget = new int[]{200, 300, 300};
        int plan = 5;
        int[] w = new int[]{12, 20, 30, 50, 100};
        int v[] = new int[]{2, 4, 5, 5, 18};


        int w1[] = new int[w.length * plan * n];
        for (int i = 0; i < w.length; i++) {
            for (int k = 0; k < plan * n; k++) {
                w1[i * plan * n + k] = w[i];
            }
        }
        System.out.println("w1 :");
        for (int i = 0; i < w1.length; i++) {
            System.out.print(w1[i] + " ");
        }
        System.out.println();

        int v1[] = new int[v.length * plan * n];
        for (int i = 0; i < v.length; i++) {
            for (int k = 0; k < plan * n; k++) {
                v1[i * plan * n + k] = v[i];
            }
        }
        System.out.println("v1:");
        for (int i = 0; i < v1.length; i++) {
            System.out.print(v1[i] + " ");
        }
        int money = 0;
        for (int i = 0 ;i < budget.length; i ++) {
            System.out.println("budget = " + budget[i]);
            int[] x = maxKickback(budget[i], w1, v1, plan);
            System.out.println("解空间 " + i + ": ");
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[j] + " ");
                money += x[j] * v1[j];
            }
            System.out.println("money " + i + " : " + money);
        }
        System.out.println();
        System.out.println("money = " + money);




    }

    private int[] maxKickback(int c, int[] w, int[] v, int plan) {
        int m[][] = new int[w.length + 1][c + 1];
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
                    if (m[i - 1][j - w[i - 1]] + v[i - 1] >= m[i - 1][j]) {
                        m[i][j] = m[i - 1][j - w[i - 1]] + v[i - 1];
                    } else {
                        m[i][j] = m[i - 1][j];
                    }
                }
            }
        }

        System.out.println();
        System.out.println("m:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
        int[] x = new int[w.length];
        int j = c;
        int sum = 0;
        for (int i = w.length; i > 0; i--) {
            if (m[i][j] == m[i - 1][j]) {
                x[i - 1] = 0;
            } else {
/*                sum += (i % plan);
                if (sum <= plan) {

                }*/
                x[i - 1] = 1;
                j = j - w[i - 1];
            }
        }
        return x;
    }

    public static void main(String[] args) {
        BagBack bagBack = new BagBack();
        bagBack.ciceroneAbacus();
    }
}
