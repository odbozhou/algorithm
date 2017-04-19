package leetcode;

/**
 * Created by zhoubo on 2017/4/19.
 */
public class ReverseInteger {
    public int reverse(int x) {
System.out.println(Math.abs(x));
/*        if (Math.abs(x) < 10) {
            return x;
        }*/
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append("-");
        }
        x = Math.abs(x);
        int y;
        while(x > 0) {
            y = x % 10;
            sb.append(y);
            x = x / 10;
        }
        int result;
        try {
            result = Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }
}
