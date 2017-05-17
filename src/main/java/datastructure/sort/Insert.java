package datastructure.sort;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class Insert {
    public int[] sort(int[] arr) {
        int n = arr.length;
        int key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
