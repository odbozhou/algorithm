import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 马佳 on 2017/4/9.
 */
public class LeastCommonMultipleTest {
    @Test
    public void calculate() throws Exception {
        int m = 60;
        int n = 24;
        System.out.println("Least Common Multiple is : " + LeastCommonMultiple.calculate(m, n));
    }

}