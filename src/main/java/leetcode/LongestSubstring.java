package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class LongestSubstring {
    public static void lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (!sb.toString().contains(s.substring(j, j + 1))) {
                    sb.append(chars[j]);
                } else {
                    if (i == 0) {
                        map.put(sb.toString(), sb.toString().length());
                    } else if (((ArrayList)map.values()).get(0));
                    resultMap.put(sb.toString(), sb.toString().length());
                    break;
                }
            }
        }
        int max;
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
             max = entry.getValue();
        }
    }
}
