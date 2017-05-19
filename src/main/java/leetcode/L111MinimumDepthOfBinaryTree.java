package leetcode;

/**
 * Created by zhoubo on 2017/5/19.
 */
public class L111MinimumDepthOfBinaryTree {
    int min = Integer.MAX_VALUE / 2;
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            minLevel(root, 1);
        }
        return min;
    }

    private void minLevel(TreeNode root, int level) {
        if (null != root) {
            if (null == root.left && null == root.right) {
                if (level < min) {
                    min = level;
                }
            }
            minLevel(root.left, level + 1);
            minLevel(root.right, level + 1);
        }
    }
}
