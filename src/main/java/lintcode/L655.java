package lintcode;

/**
 * 大整数加法
 *
 * @author zhoubo
 * @create 2017-11-09 19:57
 */
public class L655 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int offset = Math.abs(len1 - len2);
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        if (len1 >= len2) {
            for (int i = len2 - 1; i >= 0; i--) {
                int tmp = Integer.parseInt(String.valueOf(num1.charAt(i + offset))) + Integer.parseInt(String.valueOf(num2.charAt(i))) + carry;
                carry = 0;
                carry = tmp / 10;
                tmp = tmp % 10;
                sb.insert(0, tmp);
            }
            int pos = len1 - len2 - 1;
            if (0 == carry) {
                sb.insert(0, num1.substring(0, pos + 1));
            }
            while (carry > 0) {
                if (pos >= 0) {
                    int tmp = carry + Integer.parseInt(String.valueOf(num1.charAt(pos)));
                    carry = 0;
                    carry = tmp / 10;
                    tmp = tmp % 10;
                    sb.insert(0, tmp);
                    pos--;
                } else {
                    sb.insert(0, carry);
                    carry = 0;
                }
            }
        } else {
            for (int i = len1 - 1; i >= 0; i--) {
                int tmp = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(i + offset))) + carry;
                carry = 0;
                carry = tmp / 10;
                tmp = tmp % 10;
                sb.insert(0, tmp);
            }
            int pos = len2 - len1 - 1;
            if (0 == carry) {
                sb.insert(0, num2.substring(0, pos + 1));
            }
            while (carry > 0) {
                if (pos >= 0) {
                    int tmp = carry + Integer.parseInt(String.valueOf(num2.charAt(pos)));
                    carry = 0;
                    carry = tmp / 10;
                    tmp = tmp % 10;
                    sb.insert(0, tmp);
                    pos--;
                } else {
                    sb.insert(0, carry);
                    carry = 0;
                }
            }
        }
        return sb.toString();
    }


}
