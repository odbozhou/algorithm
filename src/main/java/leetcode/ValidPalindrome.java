package leetcode;

/**
 * Created by jiajia on 2017/4/25.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        s = s.toLowerCase();
        int len = s.length() - 1;
        for (int i = 0, j = len; i < j; i++,j--) {
            if (s.charAt(i) > 'z' || s.charAt(i) < 'a') {
                i++;
                if (i >= j) {
                    break;
                }
            }
            if (s.charAt(j) > 'z' || s.charAt(j) < 'a') {
                j--;
                if (i >= j) {
                    break;
                }
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
