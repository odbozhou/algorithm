package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/4/18.
 */
public class ZigZagConversionTest {
    @Test
    public void convert() throws Exception {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String s = "ABCDE";
        int numRows = 3;
        System.out.println(zigZagConversion.convert(s, numRows));
    }

}