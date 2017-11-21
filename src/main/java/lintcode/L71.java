package lintcode;

import lintcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author zhoubo
 * @create 2017-11-20 17:37
 */
public class L71 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> listList = new ArrayList<>(32);
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        boolean flag1 = true;
        boolean flag2 = true;
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            List<Integer> list = null;
            while (!oddStack.isEmpty()) {
                flag2 = true;
                if (flag1) {
                    list = new ArrayList<>(16);
                    listList.add(list);
                    flag1 = false;
                }
                TreeNode treeNode = oddStack.pop();
                list.add(treeNode.val);
                if (null != treeNode.left) {
                    evenStack.push(treeNode.left);
                }
                if (null != treeNode.right) {
                    evenStack.push(treeNode.right);
                }
            }
            while (!evenStack.isEmpty()) {
                flag1 = true;
                if (flag2) {
                    list = new ArrayList<>(16);
                    listList.add(list);
                    flag2 = false;
                }
                TreeNode treeNode = evenStack.pop();
                list.add(treeNode.val);
                if (null != treeNode.right) {
                    oddStack.push(treeNode.right);
                }
                if (null != treeNode.left) {
                    oddStack.push(treeNode.left);
                }
            }
        }
        return listList;
    }
}

class NewTreeNode {
    TreeNode treeNode;
    int level;
}
