package datastructure;

/**
 * Created by zhoubo on 2017/5/13.
 */
public interface Tree<T> {
    int deleteNode(BinaryTreeNode<T> node);
    int updateNode(BinaryTreeNode<T> node);
    BinaryTreeNode<T> search(BinaryTreeNode<T> node,BinaryTreeNode<T> head);
    void inorderTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent);
    void preorderTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent);
    void subsequentTraversal(BinaryTreeNode<T> head, BinaryTreeNode<T> parent);
}
