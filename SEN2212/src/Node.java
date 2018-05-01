/**
 * Node is a custom object used in both LinkedList and BinarySearchTree.
 */
public class Node {

    private Word word;
    private Node left;
    private Node right;

    public Node(Word word) {
        this.word = word;
        left = null;
        right = null;
    }

    public Node(Word word, Node left, Node right) {
        this.word = word;
        this.left = left;
        this.right = right;
    }

    public Word getWord() {
        return word;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

}
