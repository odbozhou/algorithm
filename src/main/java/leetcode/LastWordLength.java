package leetcode;

/**
 * Created by jiajia on 2017/4/24.
 */
public class LastWordLength {
    public int countLength(String s) {
        int len = s.length() - 1;
        int count = 0;
        for (int i = len; i >= 0; i--) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                count++;
            }
            if (count > 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return count;
    }
}
