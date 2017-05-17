package datastructure.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/16.
 */
public class MyLinkListTest {
    @Test
    public void sort() throws Exception {
        LinkListNode linkListNode1 = new LinkListNode(5);
        LinkListNode linkListNode2 = new LinkListNode(10);
        LinkListNode linkListNode3 = new LinkListNode(3);
        LinkListNode linkListNode4 = new LinkListNode(2);
        LinkListNode linkListNode5 = new LinkListNode(1);
        linkListNode1.next = linkListNode2;
        linkListNode2.next = linkListNode3;
        linkListNode3.next = linkListNode4;
        linkListNode4.next = linkListNode5;
        linkListNode5.prew = linkListNode4;
        linkListNode4.prew = linkListNode3;
        linkListNode3.prew = linkListNode2;
        linkListNode2.prew = linkListNode1;
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.sort(linkListNode1);
        LinkListNode p = linkListNode1;
        while (null != p) {
            System.out.println(p.value);
            p = p.next;
        }
    }

}