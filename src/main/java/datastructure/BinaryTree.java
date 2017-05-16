package datastructure;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhoubo on 2017/5/13.
 */
public class BinaryTree<T> implements Tree<T>{
    BinaryTreeNode<T> binaryTreeNodeHead;
    private Comparator<T> comparator;
    private int compare(T a, T b) {
        if (null != comparator) {
            return comparator.compare(a, b);
        } else {
            Comparable<T> t = (Comparable<T>)a;
            return t.compareTo(b);
        }
    }
    public int insertNode(BinaryTreeNode<T> node, BinaryTreeNode<T> head) {
        BinaryTreeNode<T> binaryTreeNode = search(node ,head ,null);
        if (compare(binaryTreeNode.value, node.value) > 0) {
            binaryTreeNode.leftChild = node;
        } else {
            binaryTreeNode.righChild = node;
        }
        return 0;
    }

    public int deleteNode(BinaryTreeNode<T> node) {
        return 0;
    }

    public int updateNode(BinaryTreeNode<T> node) {

        return 0;
    }

    public BinaryTreeNode search(BinaryTreeNode<T> node, BinaryTreeNode<T> head) {
        if (null == head || null == node) {
            return null;
        }
        BinaryTreeNode<T> binaryTreeNode = head;
        if (null != binaryTreeNode) {
            if (compare(binaryTreeNode.value, node.value) > 0) {
                binaryTreeNode = binaryTreeNode.leftChild;
                return search(node, binaryTreeNode);
            } else if (compare(binaryTreeNode.value, node.value) < 0){
                binaryTreeNode = binaryTreeNode.righChild;
                return search(node, binaryTreeNode);
            } else {
                return binaryTreeNode;
            }
        }
        return binaryTreeNode;
    }

    public BinaryTreeNode search(BinaryTreeNode<T> node, BinaryTreeNode<T> head, BinaryTreeNode parent) {
        if (null == head || null == node) {
            return parent;
        }
        BinaryTreeNode<T> binaryTreeNode = head;
        if (null != binaryTreeNode) {
            if (compare(binaryTreeNode.value, node.value) > 0) {
                parent = binaryTreeNode;
                binaryTreeNode = binaryTreeNode.leftChild;
                return search(node, binaryTreeNode, parent);
            } else if (compare(binaryTreeNode.value, node.value) < 0){
                parent = binaryTreeNode;
                binaryTreeNode = binaryTreeNode.righChild;
                return search(node, binaryTreeNode,parent);
            } else {
                return parent;
            }
        }
        return parent;
    }

    public void inorderTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent) {
        if (null == head) {
            return;
        }
        BinaryTreeNode<T> binaryTreeNode = head;
        parent = binaryTreeNode;
        binaryTreeNode = binaryTreeNode.leftChild;
        inorderTraversal(binaryTreeNode, parent);
        System.out.println(head.value);
        binaryTreeNode = parent.righChild;
        inorderTraversal(binaryTreeNode, parent);
    }

    public void preorderTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent) {
        if (null == head) {
            return;
        }
        BinaryTreeNode<T> binaryTreeNode = head;
        System.out.println(head.value);
        parent = binaryTreeNode;
        binaryTreeNode = binaryTreeNode.leftChild;
        preorderTraversal(binaryTreeNode, parent);
        binaryTreeNode = parent.righChild;
        preorderTraversal(binaryTreeNode, parent);
    }

    public void subsequentTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent) {
        if (null == head) {
            return;
        }
        BinaryTreeNode<T> binaryTreeNode = head;
        parent = binaryTreeNode;
        binaryTreeNode = binaryTreeNode.leftChild;
        subsequentTraversal(binaryTreeNode, parent);
        binaryTreeNode = parent.righChild;
        subsequentTraversal(binaryTreeNode, parent);
        System.out.println(head.value);
    }

    public void levelOrderTraversal() {
        BinaryTreeNode<T> binaryTreeNode = binaryTreeNodeHead;
        Queue<BinaryTreeNode<T>> queue = new ArrayBlockingQueue<BinaryTreeNode<T>>(20);
        queue.add(binaryTreeNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> binaryTreeNode1 = queue.remove();
            System.out.println(binaryTreeNode1.value);
            if (null != binaryTreeNode1.leftChild) {
                queue.add(binaryTreeNode1.leftChild);
            }
            if (null != binaryTreeNode1.righChild) {
                queue.add(binaryTreeNode1.righChild);
            }
        }

    }


}

class BinaryTreeNode<T> {
    BinaryTreeNode leftChild;
    BinaryTreeNode righChild;
    T value;
    public BinaryTreeNode(T value) {
        this.value = value;
    }
}
