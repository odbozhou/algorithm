package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class TowerOfHanoiTest {
    @Test
    public void hanoi() throws Exception {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.hanoi("A", "C", "B", 3);
    }

}