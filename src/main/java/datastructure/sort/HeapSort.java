package datastructure.sort;

/**
 * 堆排序(大顶堆)
 *
 * @author zhoubo
 * @create 2017-11-07 15:02
 */
public class HeapSort {
    public void heapAdjust(int[] a, int s, int m) {
        int key = a[s];
        for (int j = 2 * s; j <= m; j *= 2) {
            if (j < m && a[j] < a[j + 1]) {
                j++;
            }
            if (key >= a[j]) {
                break;
            }
            a[s] = a[j];
            s = j;
        }
        a[s] = key;
    }

    public void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, a.length - 1);
        }
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
            heapAdjust(a, i + 1, a.length - 1);
        }
    }
}
