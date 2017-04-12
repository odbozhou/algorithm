package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class LongestSubstring {

    //dedv
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

    public static int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1) {
            return  1;
        }
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        int count = 0;
        String tmpStr = null;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                sb.append(chars[0]);
            }
            if (null != tmpStr) {
                sb.append(tmpStr);
                tmpStr = null;
            }
            int countj = 1;
            for (int j = i + 1; j < chars.length; j++) {
                String sub = s.substring(j, j + 1);
                String sBuilder = sb.toString();
                if (!sBuilder.contains(sub)) {
                    countj++;
                    sb.append(chars[j]);
                    if (j == chars.length - 1) {
                        resultMap.put(sb.toString(), sb.toString().length());
                        if (sb.toString().length() > count) {
                            count = sb.toString().length();
                        }
                    }
                } else {
                    resultMap.put(sb.toString(), sb.toString().length());
                    i = i + countj - 1;
//                    countj = 0;
                    if (sb.toString().length() > count) {
                        count = sb.toString().length();
                    }
                    int position = sBuilder.indexOf(sub);
                    sb.append(chars[j]);
                    sBuilder = sb.toString();
                    tmpStr = sBuilder.substring(position + 1);
                    break;
                }
            }
        }
        return count;
    }
}
