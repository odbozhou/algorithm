package leetcode;

/**
 * Created by 马佳 on 2017/4/16.
 * f(n) = f(n-1) + f(n-2)
 */
public class ClimbingStairs {
    public static int solution(int n) {
        if (n == 1 || n == 2) {
            System.out.println(n);
            return n;
        } else {
            int k = solution(n - 1) + solution(n - 2);
            System.out.println(n);
            return k;
        }
    }

    public int dfs(int n, int[] array) {
        if (array[n] != 0) {
            return array[n];
        } else {
            array[n] = dfs(n - 1, array) + dfs(n -2, array);
            return array[n];
        }
    }

    /**
     * 备忘录法
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            int[] array = new int[n + 1];
            array[1] = 1;
            array[2] = 2;
            int k = dfs(n - 1, array) + dfs(n - 2, array);
            return k;
        }
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            int[] array = new int[n + 1];
            array[1] = 1;
            array[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array[n];
        }
    }

    /**
     * 优化动态规划
     * 优化了空间复杂度从 从O(n)降到O(1)
     * @param n
     * @return
     */
    public int solution3(int n) {
        int z = 0;
        if (n == 1 || n == 2) {
            return n;
        } else {
            int x = 1;
            int y = 2;
            for (int i = 3; i < n + 1; i++) {
                z = x + y;
                x = y;
                y = z;
            }
            return z;
        }
    }

    /**
     *  斐波那契通项公式
     *
     * @param n
     * @return
     */
    public int solution4(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
           return (int) Math.floor(
                   (1 / Math.sqrt(5.0)) * ((Math.pow((1 + Math.sqrt(5.0)) / 2.0, n + 1) - (Math.pow((1 - Math.sqrt(5.0))/2,n + 1))
                   )));
        }
    }
}
