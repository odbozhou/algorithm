package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/12.
 */
public class L518CoinChange2Test {
    @Test
    public void change() throws Exception {
        L518CoinChange2 coinChange = new L518CoinChange2();
        int amount = 5;
        int[] conins = new int[] {1, 2, 5};
        System.out.println(coinChange.change(amount, conins));
    }

}