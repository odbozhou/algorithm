/**
 * Created by 马佳 on 2017/4/9.
 */
public class LeastCommonMultiple {
    public static int calculate(int m, int n) {
        return m * n / GeratestCommonDivisor.calculate(m, n);
    }
}
