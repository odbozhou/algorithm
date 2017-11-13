package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统最长文件路径
 * <p>
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 *
 * @author zhoubo
 * @create 2017-11-13 14:01
 */
public class L643 {
    public int lengthLongestPath(String input) {
        Map<Integer, Integer> map = new HashMap(16);
        map.put(0, 0);
        int level = 0;
        int res = 0;
        int n = input.length();
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i < n && input.charAt(i) != '\n' && input.charAt(i) != '\t') {
                i++;
            }
            if (i >= n || input.charAt(i) == '\n') {
                String tmp = input.substring(start, i);
                if (tmp.indexOf('.') > 0) {
                    res = Math.max(res, map.get(level) + tmp.length());
                } else {
                    level++;
                    map.put(level, map.get(level - 1) + tmp.length() + 1);
                }
                level = 0;
            } else {
                level++;
            }
        }
        return res;
    }
}
