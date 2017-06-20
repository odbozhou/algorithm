package leetcode;

/**
 * Created by zhoubo on 2017/6/20.
 */
public class MyPow {
    public double caculate(double x, int n) {
        int oldn = n;
        n = (int)Math.abs(n);
        double y = pow(x, n);
        if (oldn < 0) {
            return 1 / y;
        }
        return y;
    }
    public double pow(double x, int n) {
        if (0 == n) {
            return 1;
        }
        double m;
        if (1 == n) {
            return x;
        }
        if (2 == n) {
            return product(x);
        }
        if (n % 2 == 0) {
            double tmp =  pow(x, n / 2);
            m = tmp * tmp;
        } else {
            double tmp =  pow(x, n / 2);
            m = x * tmp * tmp;
        }
        return m ;
    }
    private double product(double x) {
        return x * x;
    }
}
