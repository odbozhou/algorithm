import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 马佳 on 2017/4/9.
 */
public class GeratestCommonDivisorTest {
    @Test
    public void calculate() throws Exception {
        int m = 105;
        int n = 252;
/*        int m = 4;
        int n = 9;*/
        System.out.println("Geraters Common Divisor is : " + GeratestCommonDivisor.calculate(m, n));
    }

}