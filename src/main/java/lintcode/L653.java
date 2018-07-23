package lintcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 添加运算符
 *
 * @author zhoubo
 * @create 2017-11-09 15:54
 */
public class L653 {
    public List<String> addOperators(String num, int target) {
        if (num == null || 0 == num.length()) {
            return null;
        }
        List<String> lists = new LinkedList<>();
        int i = 0;
        addOperatorsHelper(num, target, 0, "", 0, 0, lists, 0);
        return lists;
    }

    private void addOperatorsHelper(String num, int target, int tmp, String path, int priv, int mul, List<String> lists, int i) {
        if (i < num.length() && target == tmp) {
            lists.add(path);
            return;
        }
        if (i >= num.length() && target != tmp) {
            return;
        }
        if (0 == i) {
            addOperatorsHelper(num, target, Integer.parseInt(path.charAt(i) + ""), path.charAt(i) + "", Integer.parseInt(path.charAt(i) + ""), 0, lists, i + 1);
        } else {
            addOperatorsHelper(num, target, tmp + Integer.parseInt(path.charAt(i) + ""), path + "+" + path.charAt(i), Integer.parseInt(path.charAt(i) + ""), Integer.parseInt(path.charAt(i) + ""), lists, i + 1);
            addOperatorsHelper(num, target, tmp - Integer.parseInt(path.charAt(i) + ""), path + "-" + path.charAt(i), -Integer.parseInt(path.charAt(i) + ""), Integer.parseInt(path.charAt(i) + ""), lists, i + 1);
            addOperatorsHelper(num, target, tmp + Integer.parseInt(path.charAt(i) + ""), path + "+" + path.charAt(i), Integer.parseInt(path.charAt(i) + ""), Integer.parseInt(path.charAt(i) + ""), lists, i + 1);
        }
    }
}





/*class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        char[] digits = num.toCharArray();
        int numDigits = digits.length;
        if (numDigits == 0) {
            return result;
        }
        char[] path = new char[2 * numDigits - 1];
        long n = 0;
        for (int i = 0; i < numDigits; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(result, i+1, i+1, 0, n, target, path, digits);
            if (n == 0) {
                break;
            }
        }

        return result;
    }

    private void dfs(List<String> result, int len, int pos, long left, long cur, int target, char[] path, char[] digits) {
        if (pos == digits.length) {
            if (left + cur == target) {
                result.add(new String(path, 0, len));
            }
            return;
        }
        int j = len + 1;
        int n = 0;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            dfs(result, j, i+1, left + cur, n, target, path, digits);
            path[len] = '-';
            dfs(result, j, i+1, left + cur, -n, target, path, digits);
            path[len] = '*';
            dfs(result, j, i+1, left, cur * n, target, path, digits);
            if (n == 0) {
                break;
            }
        }
    }
}*/