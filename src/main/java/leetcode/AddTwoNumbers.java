package leetcode;

/**
 * Created by zhoubo on 2017/4/11.
 */
public class AddTwoNumbers {
    public static ListNode Solution(ListNode listNode1, ListNode listNode2) {
        ListNode result = null;
        ListNode resultEnd = null;
        int r = 0;
        while(null != listNode1 && null != listNode2) {
            int x;
            if (r > 0) {
                x = listNode1.val + listNode2.val + r;
                r = 0;
            } else {
                x = listNode1.val + listNode2.val;
            }
            if (x > 9) {
                r = x / 10;
                x = x % 10;
            }
            ListNode listNode = new ListNode(x);
            if (result == null) {
                result = listNode;
                resultEnd = result;
            } else {
                resultEnd.next = listNode;
                resultEnd = listNode;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        ListNode tmpListNode = null;
        if (null != listNode1) {
            resultEnd.next = listNode1;
            tmpListNode = listNode1;
        } else if (null != listNode2) {
            resultEnd.next = listNode2;
            tmpListNode = listNode2;
        }
        if (null != tmpListNode) {
            int y = 0;
            if (r > 0) {
                y = tmpListNode.val + r;
                r = 0;
                if (y > 9) {
                    r = y / 10;
                    y = y % 10;
                }
                tmpListNode.val = y;

            }
            if (null != tmpListNode.next) {
                boolean flag = true;
                while(null != tmpListNode.next && flag) {
                    flag = false;
                    tmpListNode = tmpListNode.next;
                    if (r > 0) {
                        flag = true;
                        y = tmpListNode.val + r;
                        r = 0;
                        if (y > 9) {
                            r = y / 10;
                            y = y % 10;
                        }
                        tmpListNode.val = y;
                    }
                }
                if (r > 0) {
                    ListNode listNode = new ListNode(r);
                    tmpListNode.next = listNode;
                }
            } else {
                if (r > 0) {
                    ListNode listNode = new ListNode(r);
                    while (null != tmpListNode.next) {
                        tmpListNode = tmpListNode.next;
                    }
                    tmpListNode.next = listNode;
                }
            }
        } else {
            if (r > 0) {
                ListNode listNode = new ListNode(r);
                resultEnd.next = listNode;
            }
        }
        return result;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
