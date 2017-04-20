import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiajia on 2017/4/20.
 */
public class ReversePrintListTest {
    @Test
    public void print() throws Exception {
        ListNode<Integer> p4 = new ListNode<Integer>(4,null);
        ListNode<Integer> p3 = new ListNode<Integer>(3,p4);
        ListNode<Integer> p2 = new ListNode<Integer>(2,p3);
        ListNode<Integer> p1 = new ListNode<Integer>(1,p2);
        ReversePrintList reversePrintList = new ReversePrintList();
        reversePrintList.print(p1);
    }

}