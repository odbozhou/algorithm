package leetcode;

/**
 * Created by zhoubo on 2017/4/11.
 *
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *  Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public class TwoSum {
    public int[] calculate(int[] nums, int target) {
        int tmp;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
