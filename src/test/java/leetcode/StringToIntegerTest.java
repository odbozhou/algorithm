package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/4/19.
 */
public class StringToIntegerTest {
    @Test
    public void myAtoi() throws Exception {
        StringToInteger stringToInteger = new StringToInteger();
        String str = "2147483648";
        System.out.println(stringToInteger.myAtoi(str));
    }

}