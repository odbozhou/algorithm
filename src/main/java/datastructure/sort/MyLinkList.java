package datastructure.sort;

import sun.awt.image.ImageWatched;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class MyLinkList {
    public LinkListNode sort(LinkListNode head) {
        if (null == head) {
            return head;
        }
        LinkListNode p = head;
        LinkListNode q = p.next;
        while (null != q) {
            if (q.value < p.value) {
                int key = q.value;
                q.value = p.value;
                LinkListNode parent = null;
                while(null != p && p.value > key) {
                    p.next.value = p.value;
                    parent = p;
                    p = p.prew;
                }
                parent.value = key;
            }
            p = q;
            q = q.next;
        }
        return head;
    }
}

class LinkListNode {
    LinkListNode next;
    LinkListNode prew;
    LinkListNode head;
    LinkListNode last;
    int value;
    public LinkListNode(int value) {
        this.value = value;
    }
}
