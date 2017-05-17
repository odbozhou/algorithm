package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class ExchangeTest {
    @Test
    public void countWays() throws Exception {
        int amount = 3;
        int[] conins = new int[] {1, 2, 3};
        Exchange exchange = new Exchange();
        System.out.println(exchange.countWays(conins, conins.length, amount));
    }

}