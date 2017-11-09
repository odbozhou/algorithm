package lintcode;

import lintcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 两数之和 - BST版本
 *
 * @author zhoubo
 * @create 2017-11-08 19:15
 */
public class L689 {
    private List<Integer> lists = new LinkedList<>();

    public int[] twoSum(TreeNode root, int n) {
        int size = 0;
        for (int i = 1; i <= n / 2; i++) {
            size = lists.size();
            inorderTraversal(root, i, lists);
            if (size + 1 == lists.size()) {
                inorderTraversal(root, n - i, lists);
                if (size + 2 != lists.size()) {
                    lists.remove(size);
                }
            }
        }
        int[] a = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            a[i] = lists.get(i);
        }
        return a;
    }

    public void inorderTraversal(TreeNode treeNode, int key, List<Integer> a) {
        if (null == treeNode) {
            return;
        }
        inorderTraversal(treeNode.left, key, a);
        if (treeNode.val == key) {
            a.add(key);
        }
        inorderTraversal(treeNode.right, key, a);
    }
}
