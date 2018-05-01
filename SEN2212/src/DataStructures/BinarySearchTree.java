package DataStructures;

/**
 * Generic binary search tree data structure.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    private Node<T> createNewNode(T o) {
        return new Node(o);
    }

    public void insert(T o) {
        if (root == null)
            root = createNewNode(o);
        else {
            Node<T> parent = null;
            Node<T> current = root;

            while (current != null) {
                parent = current;

                if (o.compareTo(current.getObject()) < 0)
                    current = current.getLeft();
                else
                    current = current.getRight();
            }

            if (o.compareTo(parent.getObject()) < 0)
                parent.setLeft(createNewNode(o));
            else
                parent.setRight(createNewNode(o));
        }
        size++;
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.getLeft());
        System.out.println(root.getObject() + " ");
        inorder(root.getRight());
    }

    public void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.println(root.getObject() + " ");
    }

    public void preorder(Node root) {
        if (root == null)
            return;

        System.out.println(root.getObject() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

}