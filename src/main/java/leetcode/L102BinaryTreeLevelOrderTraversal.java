package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class L102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (null == root) {
            return lists;
        } else {
            Queue<TreeNode> queue1 = new LinkedBlockingQueue<TreeNode>();
            Queue<TreeNode> queue2 = new LinkedBlockingQueue<TreeNode>();
            boolean flag = true;
            queue1.add(root);
            List<Integer> integers;
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                integers = new LinkedList<Integer>();
                while (!queue1.isEmpty() && flag) {
                    TreeNode treeNode = queue1.remove();
                    if (null != treeNode) {
                        integers.add(treeNode.val);
                    }
                    if (null != treeNode.left) {
                        queue2.add(treeNode.left);
                    }
                    if (null != treeNode.right) {
                        queue2.add(treeNode.right);
                    }
                }
                flag = false;
                if (integers.size() >= 1) {
                    lists.add(integers);
                }
                integers = new LinkedList<Integer>();
                while (!queue2.isEmpty() && !flag) {
                    TreeNode treeNode = queue2.remove();
                    if (null != treeNode) {
                        integers.add(treeNode.val);
                    }
                    if (null != treeNode.left) {
                        queue1.add(treeNode.left);
                    }
                    if (null != treeNode.right) {
                        queue1.add(treeNode.right);
                    }
                }
                if (integers.size() >= 1) {
                    lists.add(integers);
                }
                flag = true;
            }
        }
        return lists;
    }
}
