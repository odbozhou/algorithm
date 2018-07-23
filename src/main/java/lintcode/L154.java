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
//        System.out.println(new L154().isMatch("aaaaa", "aa*a*"));
        System.out.println(new L154().isMatch("bbabacccbcbbcaaab", "*a*b..b*b"));
        System.out.println(new L154().isMatch("aaba", ".a.a"));
        System.out.println(new L154().isMatch("aa", ".*"));
        System.out.println(new L154().isMatch("aab", "c*a*b"));

    }

    public boolean isMatc3(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public boolean isMatch(String s, String p) {
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
                return isMatch(s2, s3);
            }
            if (null == s2 && null == s4) {
                return isMatch(s1, s2);
            }
            return isMatch(s1, s3) && isMatch(s2, s4);
        }
        if (p.contains("*")) {
            int pos = p.indexOf("*");
            if (s.length() - 1 < pos) {
                return isMatch(s, p.substring(0, pos));
            }
            String s1 = s.substring(0, pos);
            String s2 = s.substring(pos + 1);
            String s3 = p.substring(0, pos);
            String s4 = p.substring(pos + 1);
            if ("".equals(s1) && "".equals(s3)) {
                if (s2.length() > s4.length()) {
                    return isMatch(s2, "*" + s4);
                } else if (s2.length() < s4.length()) {
                    return isMatch("*" + s2, s4);
                } else {
                    return isMatch(s2, s4);
                }
            }
            if ("".equals(s2) && "".equals(s4)) {
                if (s1.length() > s3.length()) {
                    return isMatch(s1, s3 + "*");
                } else if (s1.length() < s3.length()) {
                    return isMatch(s1 + "*", s3);
                } else {
                    return isMatch(s1, s3);
                }
            }
        }
        return false;
    }

    public boolean isMatch2(String s, String p) {

        return s.matches(p);
    }
}
