/**
 * Created by 马佳 on 2017/4/9.
 */
public class GeratestCommonDivisor {
    public static int calculate(int m, int n) {
        if (n > m) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        if (m % n == 0) {
            return n;
        } else {
            int tmp = m % n;
            m = n;
            n = tmp;
            return calculate(m, n);
        }
    }
}
