import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiajia on 2017/4/21.
 */
public class MiniListTest {
    @Test
    public void arrayAsList() throws Exception {
        Integer[] integers = new Integer[]{1, 2, 3, 4};
        MiniList<Integer> integerMiniList = new MiniList<Integer>();
        integerMiniList.arrayAsList(integers);
        integerMiniList.print();
        integerMiniList.printReverse();

        ListNode<Integer> p4 = new ListNode<Integer>(4,null);
        ListNode<Integer> p3 = new ListNode<Integer>(3,p4);
        ListNode<Integer> p2 = new ListNode<Integer>(2,p3);
        ListNode<Integer> p1 = new ListNode<Integer>(1,p2);

        System.out.println("recursive");
        integerMiniList.printReverse();


    }

}