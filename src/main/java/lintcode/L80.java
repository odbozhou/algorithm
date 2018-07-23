package lintcode;

/**
 * 中位数
 *
 * @author zhoubo
 * @create 2017-11-02 16:26
 */
public class L80 {
    public int median(int[] nums) {
        int len = nums.length;
        selectSort(nums);
        if (0 == len % 2) {
            return nums[len / 2 - 1];
        } else {
            return nums[len / 2];
        }
    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] a) {
        int len = a.length;
        int i = 0;
        int j = len - 1;
        int key = a[0];
        for (int k = 0; k < a.length; k++) {
            quickSort(a, 0, len - 1, a[k]);
        }

    }

    public void quickSort(int[] a, int start, int end, int key) {
        if (start == end) {
            return;
        }
        int i = start;
        int j = end;
        while (i != j) {
            for (; j >= start; j--) {
                if (a[j] < key) {
                    int tmp = a[j];
                    a[j] = key;
                    key = tmp;
                    break;
                }
            }
            for (; i <= end; i++) {
                if (a[i] > key) {
                    int tmp = a[i];
                    a[i] = key;
                    key = tmp;
                    break;
                }
            }
        }
    }
}
