package leetcode;

/**
 * Created by zhoubo on 2017/6/26.
 */
public class L34SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        int begin = -1;
        int end = -1;
        int key = -1;
        while (low < high) {
            if (target == nums[mid]) {
                key = mid;
                break;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == high) {
            if (target == nums[low]) {
                key = low;
            }
        }
        if (-1 != key) {
            begin = end = key;
            while (nums[--begin] == target) {
                if (begin == 0) {
                    break;
                }
            }
            if (nums[begin] != target) {
                begin++;
            }
            while (nums[++end] == target) {
                if (end == nums.length - 1) {
                    break;
                }
            }
            if (nums[end] != target) {
                end--;
            }
        }
        return null;

    }
}
