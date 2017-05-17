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
        int n = len - 1;
        int m = amount;
        int[][] arr = new int[len][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            arr[i][0] = 1;
        }
        for (int i= 0 ; coins[0] * i <= amount; i++) {
            arr[0][coins[0] * i] = 1;
        }
        caculate(n, m, amount, coins, arr);
        return arr[n - 1][m];
    }

    public int caculate(int n, int m, int amount, int[] coins, int[][] arr) {
//        List list = Arrays.asList(coins);
        if (n >= 1) {
            if (arr[n][m] != 0) {
//            arr[n][m] = 1;
                return arr[n][m];
            } else {
                if (m >= coins[n - 1]) {
                    return  caculate(n - 1, m, amount, coins, arr) + caculate(n - 1, m - coins[n - 1], amount, coins, arr);//arr[n - 1][m] + arr[n - 1][m - coins[n - 1]];
                } else {
                    return caculate(n - 1, m - coins[n - 1], amount, coins, arr);
                }
            }
        } else {
            return -1;
        }

    }
}


class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(n==0||penny==null||aim<0){
            return 0;
        }
        int[][] pd = new int[n][aim+1];
        for(int i=0;i<n;i++){
            pd[i][0] = 1;
        }
        for(int i=1;penny[0]*i<=aim;i++){
            pd[0][penny[0]*i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=aim;j++){
                if(j>=penny[i]){
                    pd[i][j] = pd[i-1][j]+pd[i][j-penny[i]];
                }else{
                    pd[i][j] = pd[i-1][j];
                }
            }
        }
        return pd[n-1][aim];
    }
}
