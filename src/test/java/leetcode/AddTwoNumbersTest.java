package leetcode;

import org.junit.Test;

import java.io.File;
import java.net.Inet4Address;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class AddTwoNumbersTest {
    @Test
    public void solution() throws Exception {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(8);
/*        ListNode listNode3 = new ListNode(3);*/
        ListNode listNode4 = new ListNode(0);
/*        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);*/
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        ListNode result = AddTwoNumbers.Solution(listNode1, listNode4);
        while(null != result) {
            System.out.println(result.val);
            result = result.next;
        }


        String name = System.getProperty("user.dir");
        name = name.substring(name.lastIndexOf(File.separator) + 1);
        name = name+"_"+ Inet4Address.getLocalHost().toString().replaceAll("/", "_");
        System.out.println(name);


        System.out.println(4 >> 1);
    }

}