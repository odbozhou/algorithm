package leetcode;

/**
 * Created by jiajia on 2017/6/20.
 */
public class L153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }
        int position = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                position = i;
                break;
            }
        }
        if (position < nums.length - 1) {
            revertArray(nums, 0, position);
            revertArray(nums, position + 1, nums.length - 1);
            revertArray(nums, 0, nums.length - 1);
        }
        return nums[0];
    }

    public void revertArray(int[] arr, int begin,int end) {
        int n = end - begin + 1;
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[begin + i];
            arr[begin + i] = arr[end -  i];
            arr[end -  i] = tmp;
        }
    }
}
