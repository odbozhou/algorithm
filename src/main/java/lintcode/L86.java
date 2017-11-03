package lintcode;

import lintcode.util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉查找树迭代器
 *
 * @author zhoubo
 * @create 2017-11-03 14:29
 */
public class L86 {
}


class BSTIterator {

    List<TreeNode> treeNodes = new LinkedList<>();
    Iterator<TreeNode> iterator;

    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        iterator = treeNodes.iterator();
    }


    public boolean hasNext() {
        return iterator.hasNext();
    }


    public TreeNode next() {
        return iterator.next();
    }

    public void inorderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inorderTraversal(treeNode.left);
        treeNodes.add(treeNode);
        inorderTraversal(treeNode.right);
    }
}
