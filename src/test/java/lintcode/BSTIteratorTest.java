package lintcode;

import lintcode.util.TreeNode;
import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-03 14:38
 */
public class BSTIteratorTest {
    @Test
    public void inorderTraversal() throws Exception {
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(12);
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = treeNode2;
        treeNode2.right = treeNode3;
        treeNode1.right = treeNode4;
        treeNode4.right = treeNode5;

        BSTIterator bstIterator = new BSTIterator(treeNode1);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next().val);
        }
    }

}