package datastructure.sort;

/**
 * 快速排序
 *
 * @author zhoubo
 * @create 2017-11-06 19:49
 */
public class QuickSort {
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            boolean flag1 = false;
            boolean flag2 = false;
            int pos = partion(a, low, high, flag1, flag2);
            if (flag1) {
                System.out.println("地位排序 pos = " + pos);
                quickSort(a, low, pos - 1);
            }
            if (flag2) {
                System.out.println("高位排序 pos = " + pos);
                quickSort(a, pos + 1, high);
            }
        }
    }

    private int partion(int[] a, int low, int high) {
        int privotKey = a[low];
        a[0] = a[low];
        while (low < high) {
            while (low < high && a[high] >= privotKey) {
                --high;
            }
            a[low] = a[high];
            while (low < high && a[low] <= privotKey) {
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }

    private int partion(int[] a, int low, int high, boolean flag1, boolean flag2) {
        int privotKey = a[low];
        a[0] = a[low];
        while (low < high) {
            while (low < high && a[high] >= privotKey) {
                flag2 = true;
                --high;
            }
            a[low] = a[high];
            while (low < high && a[low] <= privotKey) {
                flag1 = true;
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }
}
