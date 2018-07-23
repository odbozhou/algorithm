package lintcode;

/**
 * 最小划分
 *
 * @author zhoubo
 * @create 2017-11-10 14:23
 */
public class L724 {

    public int findMin(int[] arr) {
        if (0 == arr.length) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = sum / 2; j >= arr[i]; j--) {
                dp[j] = dp[j - arr[i]] + arr[i] > dp[j] ? dp[j - arr[i]] + arr[i] : dp[j];
            }
        }
        return Math.abs(sum - 2 * dp[sum / 2]);
    }

    public int findMin1(int[] arr) {
        if (0 == arr.length) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[][] dp = new int[arr.length][sum / 2 + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < sum / 2 + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = sum / 2; j >= arr[i]; j--) {
                dp[i][j] = dp[i][j - arr[i]] + arr[i] > dp[i][j] ? dp[i][j - arr[i]] + arr[i] : dp[i][j];
            }
        }
        return Math.abs(sum - 2 * dp[arr.length - 1][sum / 2]);
    }
}
