package lintcode;/**
 * Created by jiajia on 2017/11/30.
 */

/**
 * @author jiajia
 * @version V1.0
 * @Description: 字符串查找
 * @date 2017/11/30 23:08
 */
public class L13 {
    public int strStr1(String source, String target) {
        if (null == source || null == target) {
            return -1;
        }
        return source.indexOf(target);
    }

    public int strStr(String source, String target) {
        if (null == source || null == target) {
            return -1;
        }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            for (int j = 0; j <= target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                if (target.length() - 1 == j) {
                    return i;
                }
            }
        }
        return -1;
    }
}
