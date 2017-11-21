package lintcode;

import lintcode.util.TreeNode;
import org.junit.Test;

/**
 * @author zhoubo
 * @create 2017-11-21 17:38
 */
public class L71Test {
    @Test
    public void zigzagLevelOrder() throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        root.left = treeNode1;
        root.right = treeNode2;
        new L71().zigzagLevelOrder(root);
    }

}