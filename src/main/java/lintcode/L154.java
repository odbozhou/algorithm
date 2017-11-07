package lintcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配
 *
 * @author zhoubo
 * @create 2017-11-07 17:45
 */
public class L154 {
    public static void main(String[] args) {
        System.out.println(new L154().isMatch("aaa", "ab*"));
//        System.out.println(new L154().isMatch2("bbabacccbcbbcaaab", "*a*b..b*b"));
        System.out.println(new L154().isMatch1("aaba", ".a.a"));
    }

    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public boolean isMatch1(String s, String p) {
        if (null != s && null != p && !p.contains(".") && !p.contains("*")) {
            return s.equals(p);
        }
        if (p.contains(".")) {
            if (s.length() != p.length()) {
                return false;
            }
            int pos = p.indexOf(".");
            String s1 = s.substring(0, pos);
            String s2 = s.substring(pos + 1);
            String s3 = p.substring(0, pos);
            String s4 = p.substring(pos + 1);
            if (null == s1 && null == s3) {
                return isMatch1(s2, s3);
            }
            if (null == s2 && null == s4) {
                return isMatch1(s1, s2);
            }
            return isMatch1(s1, s3) && isMatch1(s2, s4);
        }
        if (p.contains("*")) {
            int pos = p.indexOf("*");
            String s1 = s.substring(0, pos);
            String s2 = s.substring(pos + 1);
            String s3 = p.substring(0, pos);
            String s4 = p.substring(pos + 1);
            if (null == s1 && null == s3) {
                if (s2.length() > s4.length()) {
                    return isMatch1(s2, s4 + "*");
                } else if (s2.length() < s4.length()) {
                    return isMatch1(s2 + "*", s4);
                } else {
                    return isMatch1(s2, s4);
                }
            }
            if (null == s2 && null == s4) {
                if (s1.length() > s3.length()) {
                    return isMatch1(s1, s3 + "*");
                } else if (s1.length() < s3.length()) {
                    return isMatch1(s1 + "*", s3);
                } else {
                    return isMatch1(s1, s3);
                }
            }
        }
        return false;
    }

    public boolean isMatch2(String s, String p) {

        return s.matches(p);
    }
}
