package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class L144BinaryTreePreorderTraversql {
    List<Integer> integers = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return integers;
        } else {
            integers.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return integers;
    }
}



