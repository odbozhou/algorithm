package lintcode;

/**
 * 重复字串
 *
 * @author zhoubo
 * @create 2017-11-09 9:16
 */
public class L718 {
    public int repeatedString(String A, String B) {
        if (0 == A.length() && 0 != B.length()) {
            return -1;
        } else if (0 == A.length() && 0 == B.length()) {
            return 0;
        }
        int n = B.length() / A.length();
        for (int i = n; i <= n + 2; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j <= i; j++) {
                sb.append(A);
            }
            if (sb.toString().contains(B)) {
                return i;
            }
        }
        return -1;
    }
}
