package leetcode;

/**
 * Created by zhoubo on 2017/4/14.
 */
public class FindMedianSortedArrays {
    private int[] tmpArr;

    public static double solution(int[] nums1, int[] nums2) {
        int[] num = new int[0];
        if (0 == nums1.length) {
            num = nums2;
        }
        if (0 == nums2.length) {
            num = nums1;
        }
        if (num.length > 0) {
            int mid = 0;
            if (0 == num.length % 2) {
                mid = num.length / 2;
                return (num[mid] + num[mid - 1]) / 2.0;
            } else {
                mid = num.length / 2;
                return num[mid];
            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] tmpArr = new int[nums1.length + nums2.length];
        int flag = 1;
        while (k < tmpArr.length) {
            while (1 == flag) {
                if (nums1[i] < nums2[j]) {
                    tmpArr[k++] = nums1[i];
                    if (i == nums1.length - 1) {
                        flag = 2;
                    } else {
                        i++;
                    }
                } else {
                    tmpArr[k++] = nums2[j];
                    if (j == nums2.length - 1) {
                        flag = 3;
                    } else {
                        j++;
                    }
                }
            }
            if (flag == 2) {
                for (;j < nums2.length; j++) {
                    tmpArr[k++] = nums2[j];
                }
            } else {
                for (;i < nums1.length; i++) {
                    tmpArr[k++] = nums1[i];
                }
            }
        }
        int mid = 0;
        if (0 == tmpArr.length % 2) {
            mid = tmpArr.length / 2;
            return (tmpArr[mid] + tmpArr[mid - 1]) / 2.0;
        } else {
            mid = tmpArr.length / 2;
            return tmpArr[mid];
        }
    }
}
