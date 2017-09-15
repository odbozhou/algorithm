package leetcode;

/**
 * Created by zhoubo on 2017/6/22.
 */
public class L162FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (1 == nums.length) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (0 == i) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            if (nums.length - 1 == i) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            }
            if (i + 1 < nums.length && i - 1 >= 0 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
