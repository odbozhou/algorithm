package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class L102BinaryTreeLevelOrderTraversalTest {
    @Test
    public void levelOrder() throws Exception {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left =  treeNode4;
        treeNode3.right = treeNode5;
        L102BinaryTreeLevelOrderTraversal l102BinaryTreeLevelOrderTraversal = new L102BinaryTreeLevelOrderTraversal();
        l102BinaryTreeLevelOrderTraversal.levelOrder(treeNode1);
    }

}