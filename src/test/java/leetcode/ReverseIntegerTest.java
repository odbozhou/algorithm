package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/4/19.
 */
public class ReverseIntegerTest {
    @Test
    public void reverse() throws Exception {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = -2147483648;
        System.out.println(reverseInteger.reverse(x));
    }

}