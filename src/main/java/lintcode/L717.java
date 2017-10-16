package lintcode;

import java.util.LinkedList;
import java.util.List;

public class L717 {
    public int longestPathWithSameValue(int[] A, int[] E) {
        int n = A.length;
        int[] count = new int[n];
        int max = 0;
//        List<BinaryTreeNode> binaryTreeNodes = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode[] binaryTreeNodes = new BinaryTreeNode[n];
        for (int j = 0 ; j <= n - 2; j++) {
            BinaryTreeNode parent;
            BinaryTreeNode child;
            if (null == binaryTreeNodes[E[2 * j] - 1]) {
                parent = new BinaryTreeNode(A[E[2 * j] - 1]);
                binaryTreeNodes[E[2 * j] - 1] = parent;
            }
            if (null == binaryTreeNodes[E[2 * j + 1] - 1]) {
                child = new BinaryTreeNode(A[E[2 * j + 1] - 1]);
                binaryTreeNodes[E[2 * j + 1] - 1] = child;
            }
            binaryTreeNodes[E[2 * j + 1] - 1].parent = binaryTreeNodes[E[2 * j] - 1];
            if (null == binaryTreeNodes[E[2 * j] - 1].lchild) {
                binaryTreeNodes[E[2 * j] - 1].lchild = binaryTreeNodes[E[2 * j + 1] - 1];
            } else {
                binaryTreeNodes[E[2 * j] - 1].rchild = binaryTreeNodes[E[2 * j + 1] - 1];
            }
        }
        BinaryTreeNode node = null;
        if (null != binaryTreeNodes && binaryTreeNodes.length > 0) {
            node = binaryTreeNodes[0];
        }
        BinaryTreeNode head;
        while (null != node && null != node.parent) {
            node = node.parent;
        }
        System.out.println("head = " + node.value);
        head = node;
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("preorderTraversal");
        binaryTree.preorderTraversal(head);
        System.out.println("inorderTraversal");
        binaryTree.inorderTraversal(head);
        System.out.println("postorderTraversal");
        binaryTree.postorderTraversal(head);
        return max;
    }

    public static void main(String[] args) {
/*        BinaryTreeNode head = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        head.lchild = node1;
        head.rchild = node2;
        node1.lchild = node3;
        node1.rchild = node4;
        node2.lchild = node5;
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("preorderTraversal");
        binaryTree.preorderTraversal(head);
        System.out.println("inorderTraversal");
        binaryTree.inorderTraversal(head);
        System.out.println("postorderTraversal");
        binaryTree.postorderTraversal(head);*/
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] e = new int[] {1, 2, 1, 3, 2, 4, 2, 5};
        new L717().longestPathWithSameValue(a, e);
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode lchild;
    BinaryTreeNode rchild;
    BinaryTreeNode parent;

    public BinaryTreeNode(int value, BinaryTreeNode lchild, BinaryTreeNode rchild) {
        this.value = value;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public BinaryTreeNode(int value) {
        this(value, null, null);
    }
}

class BinaryTree {
/*    private BinaryTreeNode head;
    public BinaryTree(BinaryTreeNode head) {
        this.head = head;
    }*/

    public void preorderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        System.out.println(node.value);
        preorderTraversal(node.lchild);
        preorderTraversal(node.rchild);
    }

    public void inorderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.lchild);
        System.out.println(node.value);
        inorderTraversal(node.rchild);
    }

    public void postorderTraversal(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        postorderTraversal(node.lchild);
        postorderTraversal(node.rchild);
        System.out.println(node.value);
    }
}
