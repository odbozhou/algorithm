package leetcode;

/**
 * Created by zhoubo on 2017/5/19.
 */
public class L104MaximumDepthOfBinaryTree {
    int max = 0;
    public int maxDepth(TreeNode root) {
/*     方法一
       if (null == root) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + (left > right ? left : right);
        }*/
        maxLevel(root, 0);
        return max;
    }

    private void maxLevel(TreeNode root, int level) {
        if (null == root) {
            return;
        } else {
            if (level > max) {
                max = level;
            }
            maxLevel(root.left, level + 1);
            maxLevel(root.right, level + 1);
        }
    }
}
