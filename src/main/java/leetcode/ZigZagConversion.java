package leetcode;

/**
 * Created by zhoubo on 2017/4/18.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[][] chars = new char[numRows][];
        for (int k = 0; k < s.length(); ) {
            int j = 0;
            int i = 0;
            if ((j + 1) % numRows == 0 || k == 0) {
                for (; i < numRows; i++) {
                    chars[i][j] = s.charAt(k);
                    k++;
                }
                j++;
            } else {
                int r = j % numRows;
                int y = j / numRows;
                i = (numRows - 1 - ((numRows - 1) - j)) + (y * numRows);
//                j = (y + 1) *
                chars[i][j] = s.charAt(k);
                j++;
                k++;
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.println(chars[i][j]);
            }
        }
        return null;
    }
}
