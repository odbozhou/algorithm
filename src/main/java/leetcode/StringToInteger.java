package leetcode;

/**
 * Created by zhoubo on 2017/4/19.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        int result = 0;
        int signed = 1;
        str = str.toLowerCase();
        int len = str.length();
        int i = 0;
        if (str.charAt(0) == '+') {
            i = 1;
        } else if (str.charAt(0) == '-'){
            i = 1;
            signed = -1;
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return result;
            }
            result = result + (str.charAt(i) - '1' + 1) * (int)(Math.pow(10, len - i - 1));
        }
        return result * signed;
    }
}
