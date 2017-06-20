package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/6/20.
 */
public class MyPowTest {
    @Test
    public void caculate() throws Exception {
        MyPow myPow = new MyPow();
        System.out.println(myPow.caculate(2, 1));
        System.out.println(myPow.caculate(2, 2));
        System.out.println(myPow.caculate(2, 3));
        System.out.println(myPow.caculate(2, 4));
        System.out.println(myPow.caculate(2, 5));
        System.out.println(myPow.caculate(2, 6));
        System.out.println(myPow.caculate(2, 7));
        System.out.println(myPow.caculate(2, 8));
        System.out.println(myPow.caculate(2, 9));
        System.out.println(myPow.caculate(2, 10));
        System.out.println(myPow.caculate(34.00515,-3));
        System.out.println(myPow.caculate(22.14659,-2));
        System.out.println(myPow.caculate(0.00001,2147483647));
    }

}