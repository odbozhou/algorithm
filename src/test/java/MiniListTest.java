import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        System.out.println("max: ");
//        integerMiniList.getMax();
        System.out.println("add: ");
        integerMiniList.add(8);
        integerMiniList.print();

        System.out.println("add: ");
        integerMiniList.add(10);
        integerMiniList.print();

        System.out.println("remove: ");
        integerMiniList.remove(0);
        integerMiniList.print();
        System.out.println("remove: ");
        integerMiniList.remove(4);
        integerMiniList.print();
        System.out.println("remove: ");
        integerMiniList.remove(1);
        integerMiniList.print();

        List list = new LinkedList();
        System.out.println("2 << 1: ");
        System.out.println( 2 >> 1);
    }

}