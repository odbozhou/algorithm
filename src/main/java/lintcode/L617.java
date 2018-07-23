package lintcode;

/**
 * 最大平均值子数组
 *
 * @author zhoubo
 * @create 2017-11-13 19:42
 */
public class L617 {
    public double maxAverage(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        double res = sums[k - 1] * 1.0 / k;
        for (int i = k; i < sums.length; i++) {
            res = Math.max(res, (sums[i] - sums[i - k]) * 1.0 / k);
        }
        return res;
    }

    public double maxAverage1(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum + nums[i] - nums[i - k]) * 1.0 / k);
        }
        return res;
    }

}
