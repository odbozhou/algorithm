package book;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class CommonLongestSubsequenceTest {
    @Test
    public void lcsLength() throws Exception {
        CommonLongestSubsequence commonLongestSubsequence = new CommonLongestSubsequence();
        String[] x = new String[] {"A", "B" ,"C" , "B", "D" , "A", "B"};
        String[] y = new String[] {"B", "D", "C", "A", "B", "A"};
        commonLongestSubsequence.lcsLength(x, y);
    }

}