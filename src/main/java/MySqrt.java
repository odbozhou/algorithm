/**
 * Created by jiajia on 2017/5/22.
 */
public class MySqrt {
    public void sqrt(double n) {
        double min = 0;
        double max = n;
        double mid = ((min + max) / 2.0);
        double qow = mid * mid;
        while (min < max) {
            if (qow > max) {
                max = mid;
                mid = (min + max) / 2.0;
                qow = mid * mid;
            } else {
                min = mid;
                mid = (min + max) / 2.0;
                qow = mid * mid;
            }
        }
    }
}
