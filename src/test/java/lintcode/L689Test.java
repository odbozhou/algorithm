package lintcode;

import lintcode.util.TreeNode;
import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-08 19:33
 */
public class L689Test {
    @Test
    public void twoSum() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode5;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        int n = 3;
        int[] a = new L689().twoSum(treeNode4, n);
        for (int x : a) {
            System.out.println(x);
        }
    }

}