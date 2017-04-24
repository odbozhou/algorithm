package leetcode;

/**
 * Created by jiajia on 2017/4/24.
 */
public class Palindrome1 {
    public boolean caculate(String s) {
        int len = s.length() - 1;
        for (int i = 0, j = len; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

        }
        return true;
    }
}
