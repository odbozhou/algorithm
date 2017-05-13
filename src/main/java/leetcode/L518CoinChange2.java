package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoubo on 2017/5/11.
 */
public class L518CoinChange2 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            return 0;
        }
        int n = len;
        int m = amount;
        int[][] arr = new int[len + 1][amount + 1];
        caculate(n, m, amount, coins, arr);
        return arr[n][m];
    }

    public int caculate(int n, int m, int amount, int[] coins, int[][] arr) {
//        List list = Arrays.asList(coins);
        boolean flag = false;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == m) {
                flag = true;
            }
        }
        if (n == 1 && flag) {
            arr[n][m] = 1;
            return arr[n][m];
        } else {
            if (m >= coins[n - 1]) {
                return  caculate(n - 1, m, amount, coins, arr) + caculate(n - 1, m - coins[n - 1], amount, coins, arr);//arr[n - 1][m] + arr[n - 1][m - coins[n - 1]];
            } else {
               return caculate(n - 1, m - coins[n - 1], amount, coins, arr);
            }
        }
    }
}
