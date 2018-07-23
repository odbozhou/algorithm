package lintcode;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-21 19:36
 */
public class L81Test {
    @Test
    public void medianII() throws Exception {
        int[] nums = new int[]{4, 5, 1, 3, 2, 6, 0};
        nums = new L81().medianII(nums);
//        Assert.assertArrayEquals(nums, new int[]{4,4,4,3,3,3,3});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
//        Assert.assertArrayEquals(nums, new int[]{4,4,1,1,1,1,2});
    }

}