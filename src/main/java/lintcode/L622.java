package lintcode;

/**
 * 猜数游戏
 *
 * @author zhoubo
 * @create 2017-11-10 9:53
 */
public class L622 {
    public int guessNumber(int n, int key) {
        int low = 1;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (-1 == guess(mid)) {
                high = mid - 1;
            } else if (1 == guess(mid)) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
