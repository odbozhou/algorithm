package leetcode;

/**
 * Created by zhoubo on 2017/4/18.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows <= 1) {
            return s;
        }
        char[][] chars = new char[numRows][s.length()];
        int j = 0;
        int i = 0;
        for (int k = 0; k < s.length(); ) {
            if (j  % (numRows - 1) == 0) {
                i = 0;
                for (; i < numRows && k < s.length(); i++) {
                    chars[i][j] = s.charAt(k);
                    k++;
                }
                j++;
            } else {
                int r = j % (numRows - 1);
                int y = j / numRows;
                i = (numRows - 1) - r;
                chars[i][j] = s.charAt(k);
                j++;
                k++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int m = 0; m < numRows; m++) {
            for (int n = 0; n < chars[m].length; n++) {
                if (chars[m][n] != 0) {
                    stringBuilder.append(chars[m][n]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
