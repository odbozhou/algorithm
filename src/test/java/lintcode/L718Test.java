package lintcode;

import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-09 11:09
 */
public class L718Test {
    @Test
    public void repeatedString() throws Exception {
        String a = "jcwsijl";
        String b = "sijljcwsijljcwsijljcwsijljcwsijljcwsijljcwsijljcwsijljcwsijljcwsijljc";
        System.out.println(new L718().repeatedString(a, b));
    }

}