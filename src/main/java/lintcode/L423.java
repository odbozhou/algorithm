package lintcode;

import java.util.Stack;

/**
 * 有效的括号序列
 * <p>
 *
 * @author zhoubo
 * @create 2017-11-14 17:53
 */
public class L423 {
    public boolean isValidParentheses(String s) {
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length() - 1) {
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
            while (i < s.length() - 1 && !characters.empty()) {
                if (characters.peek().equals('(') && chars[i + 1] != ')') {
                    break;
                } else if (characters.peek().equals('{') && chars[i + 1] != '}') {
                    break;
                } else if (characters.peek().equals('[') && chars[i + 1] != ']') {
                    break;
                }
                characters.pop();
                i++;
            }
            i++;
        }

        if (i != s.length() || !characters.empty()) {
            return false;
        }
        return true;
    }
}
