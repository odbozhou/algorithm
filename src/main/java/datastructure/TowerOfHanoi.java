package datastructure;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class TowerOfHanoi {
    public void hanoi(String start, String end, String tmp, int n) {
        if (1 == n) {
            System.out.println(start + " -> " + end);
            return;
        }
        hanoi(start, tmp, end, n - 1);
        System.out.println(start + " -> " + end);
        hanoi(tmp, end, start, n - 1);
    }
}
