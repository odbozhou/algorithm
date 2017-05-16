package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhoubo on 2017/5/13.
 */
public class BinaryTreeTest {
    @Test
    public void search() throws Exception {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        BinaryTreeNode<Integer> binaryTreeNode1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> binaryTreeNode2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> binaryTreeNode3 = new BinaryTreeNode<Integer>(3);
//        BinaryTreeNode<Integer> binaryTreeNode4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> binaryTreeNode5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> binaryTreeNode6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> binaryTreeNode7 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> binaryTreeNode8 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> binaryTreeNode9 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> binaryTreeNode0 = new BinaryTreeNode<Integer>(0);

        binaryTreeNode5.leftChild = binaryTreeNode2;
        binaryTreeNode5.righChild = binaryTreeNode7;
        binaryTreeNode2.leftChild = binaryTreeNode1;
        binaryTreeNode2.righChild = binaryTreeNode3;
        binaryTreeNode7.leftChild = binaryTreeNode6;
        binaryTreeNode7.righChild = binaryTreeNode8;

        binaryTree.binaryTreeNodeHead = binaryTreeNode5;
        BinaryTreeNode<Integer> binaryTreeNode = binaryTree.search(binaryTreeNode0, binaryTree.binaryTreeNodeHead);
        BinaryTreeNode<Integer> binaryTreeParentNode = binaryTree.search(binaryTreeNode9, binaryTree.binaryTreeNodeHead, null);
        System.out.println("中序遍历：");
        binaryTree.inorderTraversal(binaryTree.binaryTreeNodeHead, null);
        binaryTree.insertNode(binaryTreeNode9, binaryTree.binaryTreeNodeHead);
        System.out.println("中序遍历：");
        binaryTree.inorderTraversal(binaryTree.binaryTreeNodeHead, null);
        binaryTree.insertNode(binaryTreeNode0, binaryTree.binaryTreeNodeHead);

        if (null != binaryTreeNode) {
            System.out.println(binaryTreeNode.value);
        } else {
            System.out.println("not found!");
        }
        if (null != binaryTreeParentNode) {
            System.out.println(binaryTreeParentNode.value);
        } else {
            System.out.println("not found!");
        }
        System.out.println("中序遍历：");
        binaryTree.inorderTraversal(binaryTree.binaryTreeNodeHead, null);
        System.out.println("前序遍历：");
        binaryTree.preorderTraversal(binaryTree.binaryTreeNodeHead, null);
        System.out.println("后序遍历：");
        binaryTree.subsequentTraversal(binaryTree.binaryTreeNodeHead, null);
        System.out.println("层序遍历：");
        binaryTree.levelOrderTraversal();
    }

}