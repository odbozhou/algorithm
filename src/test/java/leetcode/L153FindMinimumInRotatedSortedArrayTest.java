package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiajia on 2017/6/20.
 */
public class L153FindMinimumInRotatedSortedArrayTest {
    @Test
    public void findMin() throws Exception {
        L153FindMinimumInRotatedSortedArray l153FindMinimumInRotatedSortedArray = new L153FindMinimumInRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(l153FindMinimumInRotatedSortedArray.findMin(nums));
    }

}