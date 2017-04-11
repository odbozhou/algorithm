import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 马佳 on 2017/4/9.
 */
public class AccumulationTest {
    @Test
    public void calculateReturnByException() throws Exception {
        Accumulation accumulation = new Accumulation(100);
        System.out.println("Accumulation result is : " + accumulation.calculateReturnByException(1));
    }

    @Test
    public void calculate() throws Exception {
        int n = 100;
        System.out.println("Accumulation result is : " + Accumulation.calculate(n));
    }

}