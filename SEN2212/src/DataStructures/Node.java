package DataStructures;

/**
 * Node is a custom object used in both LinkedList and BinarySearchTree.
 */
public class Node<T extends Comparable<T>> {

    private T object;
    private Node<T> left;
    private Node<T> right;

    public Node(T object) {
        this.object = object;
        left = null;
        right = null;
    }

    public Node(T object, Node<T> left, Node<T> right) {
        this.object = object;
        this.left = left;
        this.right = right;
    }

    public T getObject() {
        return object;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getRight() {
        return right;
    }

}
