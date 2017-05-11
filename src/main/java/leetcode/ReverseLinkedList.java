package leetcode;

import java.util.Stack;

/**
 * Created by zhoubo on 2017/5/11.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if ( head == null || null == head.next ) {
            return head;
        }
        ListNode p = head;
        Stack stack = new Stack();
//        stack.push(head.val);
        while (null != p) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (null != p) {
            p.val = (Integer) stack.pop();
            p = p.next;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || null == head.next) {
            return head;
        }

        return head;
    }
}
