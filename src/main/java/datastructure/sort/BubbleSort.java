package datastructure.sort;

/**
 * 冒泡排序
 *
 * @author zhoubo
 * @create 2017-11-07 10:52
 */
public class BubbleSort {
    public void sort(int[] a) {
        boolean changeFlag = true;
        for (int i = a.length - 1; i >= 0 && changeFlag; i--) {
            changeFlag = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    changeFlag = true;
                    System.out.println(changeFlag);
                }
            }
        }
    }
}
