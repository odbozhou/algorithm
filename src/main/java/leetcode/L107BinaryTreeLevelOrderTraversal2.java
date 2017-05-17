package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoubo on 2017/5/17.
 */
public class L107BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        int level = 0;
        lvs(root, level, lists);
        for (int i = 0; i < lists.size() / 2; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(lists.get(i));
            lists.set(i, lists.get(lists.size() - 1 - i));
            lists.set(lists.size() - 1 - i, tmp);
        }
        return lists;
    }

    private void lvs(TreeNode root, int level, List<List<Integer>> lists) {
        if (null == root) {
            return;
        }
        List<Integer> integers;
        if (lists.size() == level) {
            integers = new LinkedList<Integer>();
            lists.add(integers);
        } else {
            integers = lists.get(level);
        }
        lvs(root.left, level + 1, lists);
        lvs(root.right, level + 1, lists);
        integers.add(root.val);
    }
}
