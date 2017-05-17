package datastructure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/15.
 */
public class InsertTest {
    @Test
    public void sort() throws Exception {
        Insert insert = new Insert();
        int[] arr = new int[] {4, 6, 7, 1, 3, 5, 9, 0, 52};
        arr = insert.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}