package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        int count = 0;
        String subStr;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (!sb.toString().contains(s.substring(j, j + 1))) {
                    sb.append(chars[j]);
                } else {
                    break;
                }
            }
            if (sb.toString().length() > count) {
                count = sb.toString().length();
                subStr = sb.toString();
            }
            resultMap.put(sb.toString(), sb.toString().length());

        }
        return count;
    }
}
