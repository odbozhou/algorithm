package lintcode;

import java.util.Stack;

/**
 * 有效的括号序列
 * <p>
 * 错误"[({(())}[()])]"
 *
 * @author zhoubo
 * @create 2017-11-14 17:53
 */
public class L423 {
    public boolean isValidParentheses(String s) {
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }
        boolean flag = false;
        char[] chars = s.toCharArray();
        if (chars[0] == '(' && chars[1] == ')') {
            flag = true;
        } else if (chars[0] == '{' && chars[1] == '}') {
            flag = true;
        } else if (chars[0] == '[' && chars[1] == ']') {
            flag = true;
        } else {
            flag = false;
        }
        if (flag) {
            for (int i = 0; i < s.length() - 1; i += 2) {
                if (chars[i] == '(' && chars[i + 1] == ')') {
                    return true;
                } else if (chars[i] == '{' && chars[i + 1] == '}') {
                    return true;
                } else if (chars[i] == '[' && chars[i + 1] == ']') {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            Stack<Character> characters = new Stack<>();
            int i = 0;
            for (; i < s.length() - 1; i++) {
                characters.push(chars[i]);
                if (chars[i] == '(' && chars[i + 1] == ')') {
                    break;
                } else if (chars[i] == '{' && chars[i + 1] == '}') {
                    break;
                } else if (chars[i] == '[' && chars[i + 1] == ']') {
                    break;
                }
            }
            while (i < s.length() && !characters.empty()) {
                if (chars[i] == ')' && !characters.pop().equals('(')) {
                    return false;
                } else if (chars[i] == '}' && !characters.pop().equals('{')) {
                    return false;
                } else if (chars[i] == ']' && !characters.pop().equals('[')) {
                    return false;
                }
                i++;
            }
            if (i != s.length() || !characters.empty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isValidParentheses1(String s) {
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        for (; i < s.length() - 1; i++) {
            characters.push(chars[i]);
            if (chars[i] == '(' && chars[i + 1] == ')') {
                break;
            } else if (chars[i] == '{' && chars[i + 1] == '}') {
                break;
            } else if (chars[i] == '[' && chars[i + 1] == ']') {
                break;
            }
        }
        while (i < s.length() && !characters.empty()) {
            if (chars[i] == ')' && !characters.pop().equals('(')) {
                return false;
            } else if (chars[i] == '}' && !characters.pop().equals('{')) {
                return false;
            } else if (chars[i] == ']' && !characters.pop().equals('[')) {
                return false;
            }
            i++;
        }
        if (i != s.length() || !characters.empty()) {
            return false;
        }
        return true;
    }
}
