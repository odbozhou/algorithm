package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiajia on 2017/5/18.
 */
public class L226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        } else {
            invert(root, null);
        }
        return root;
    }

    private void invert(TreeNode root, TreeNode parent) {
        if (null == root) {
            return;
        } else {
            TreeNode p = root;
            TreeNode q;
            parent = p;
            p = p.left;
            q = parent.right;
            invert(p, parent);
            invert(parent.right, parent);
            parent.left = q;
            parent.right = p;
        }
    }

    private void preOrderTravel(TreeNode root) {
        if (null != root) {
            TreeNode p = root;
            TreeNode tmp;
            tmp = p.left;
            p.left = p.right;
            p.right = tmp;
            preOrderTravel(p.left);
            preOrderTravel(p.right);
        }
    }

    private void inOrderTravel(TreeNode root) {
        if (null != root) {
            TreeNode p = root;
            preOrderTravel(p.left);
            TreeNode tmp;
            tmp = p.left;
            p.left = p.right;
            p.right = tmp;
            preOrderTravel(p.left);
        }
    }

    private void levelTravel(TreeNode root) {
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.remove();
                TreeNode tmp;
                tmp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = tmp;
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
        }
    }
}
