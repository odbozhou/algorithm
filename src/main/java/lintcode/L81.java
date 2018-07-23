package lintcode;

/**
 * 数据流中位数
 *
 * @author zhoubo
 * @create 2017-11-21 19:21
 */
public class L81 {
    public int[] medianII(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (key < nums[j]) {
                    nums[j + 1] = nums[j];
                    pos = j;
                }
            }
            result[i] = nums[i / 2];
        }
        return result;
    }
}
