package lintcode.util;

/**
 * 二叉树节点
 *
 * @author zhoubo
 * @create 2017-11-03 14:30
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}