package leetcode;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class BinaryTree {
    TreeNode head;
    public  void arrayToBinaryTree(Integer[] arr) {
        if (arr.length < 1) {
            head = null;
        } else {

        }
    }
    public void insertNode(TreeNode treeNode, TreeNode parent, Integer[] arr) {
        if (null == treeNode) {
            return;
        } else {
            if (null == head) {
                head = treeNode;

            } else {
                TreeNode p = parent;

//                insertNode();
            }

        }
    }
}
