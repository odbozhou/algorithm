package leetcode;

import org.junit.Test;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class TwoSumTest {
    @Test
    public void calculate() throws Exception {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] tmp = twoSum.calculate(nums, target);
        System.out.println(twoSum.calculate(nums, target));
    }

}