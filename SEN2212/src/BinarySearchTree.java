/**
 * Generic binary search tree data structure.
 */
public class BinarySearchTree {

    private Node root;
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

    private Node createNewNode(Word word) {
        return new Node(word);
    }

    public void insert(Word w) {
        if (root == null)
            root = createNewNode(w);
        else {
            Node parent = null;
            Node current = root;

            while (current != null) {
                parent = current;

                if (w.compareTo(current.getWord()) < 0)
                    current = current.getLeft();
                else
                    current = current.getRight();
            }

            if (w.compareTo(parent.getWord()) < 0)
                parent.setLeft(createNewNode(w));
            else
                parent.setRight(createNewNode(w));
        }
        size++;
    }

    public LinkedList search(String query) {
        Node current = root;

        LinkedList results = new LinkedList();

        while (current != null) {
            Word currentWord = current.getWord();

            if (query.compareTo(currentWord.getValue()) < 0) {
                current = current.getLeft();
            } else if (query.compareTo(currentWord.getValue()) > 0) {
                current = current.getRight();
            } else {
                results.append(currentWord);
                current = current.getRight();
            }
        }

        return results;
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.getLeft());
        System.out.println(root.getWord() + " ");
        inorder(root.getRight());
    }

    public void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.println(root.getWord() + " ");
    }

    public void preorder(Node root) {
        if (root == null)
            return;

        System.out.println(root.getWord() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public void insertString(String s) {
        String currentWord = "";
        int currentStartIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (!isAllowedChar(s.charAt(i))) {

                if (!currentWord.isEmpty()) {
                    Word word = new Word(currentWord, currentStartIndex, i - 1);
                    insert(word);
                    currentWord = "";
                }
                continue;
            } else {
                if (currentWord.isEmpty()) {
                    currentStartIndex = i;
                }
            }

            currentWord += s.charAt(i);
        }
    }

    private boolean isAllowedChar(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

}