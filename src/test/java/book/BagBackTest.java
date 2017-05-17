package book;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class BagBackTest {
    @Test
    public void solution() throws Exception {
        BagBack bagBack = new BagBack();
        int w[] = new int[]{ 2, 3, 4, 5};
        int v[] = new int[]{ 3, 4, 5, 7};
        int c = 9;
        bagBack.solution(w, v, c);
    }

}